package so.wwb.creditbox.mdcenter.comet.websocket;

import org.soul.comet.websocket.model.SocketInfo;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.comet.vo.MessageVo;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 * 商户webSocket处理
 * @author marz
 * @time 2018-04-18 16:30:46
 */
public class MerchantWebSocketHandler extends LbWebSocketHandler {
    private static final Log LOG = LogFactory.getLog(MerchantWebSocketHandler.class);

    @Override
    public void sendMessage(MessageVo message) {
        List<String> userIdList = message.getUserIdList();
        Integer shareHolderId = message.getMasterId();
        Integer siteId = message.getSiteId();
        if (CollectionTool.isNotEmpty(userIdList)  && siteId != null) {
            LOG.debug("向指定站点商户后台{0}指定的在线商户登录用户ID{1}发送消息{2}", siteId, userIdList, message);
            sendMessageToUsers(siteId,userIdList,message);

        } else if (CollectionTool.isEmpty(userIdList) && siteId != null) {
            LOG.debug("向指定站点商户后台{0}的所有在线登录用户发送消息{1}", siteId,message);
            Set<Integer> ids = getAllIdListBySiteIdAndSubSysCode(siteId,SubSysCodeEnum.COMPANY.getCode());
            List<String> list = new ArrayList<>();
            if(CollectionTool.isNotEmpty(ids)){
                for(Integer id:ids){
                    list.add(id.toString());
                }
            }
            sendMessageToUsers(siteId,list,message);
        }else if(shareHolderId != null){
            Set<Integer> siteIds = getSiteIdByShareHolderId(shareHolderId);
            LOG.debug("向指定商户后台{0}的所有在线登录用户发送消息{1}", siteIds,message);
            for (Integer itemSiteId : siteIds) {
                sendMessageToSite(itemSiteId,message);
            }
        }else{
            LOG.debug("向所有商户后台的所有在线登录用户发送消息{0}", message);
            Set<Integer> siteIdList = getAllIdList();
            for (Integer id : siteIdList) {
                sendMessageToSite(id, message);
            }
        }
    }

    /**
     * 获取全部商户的id列表
     * @return
     */
    protected Set<Integer> getAllIdList() {
        return super.getAllIdList(SubSysCodeEnum.COMPANY.getCode());
    }

    /**
     * 只推送商户消息
     * @param socketInfo
     * @param messageVo
     * @return
     */
    @Override
    public boolean sessionCheck(SocketInfo socketInfo, MessageVo messageVo) {
        UserTypeEnum userType = EnumTool.enumOf(UserTypeEnum.class,socketInfo.getUserType());
        switch (userType){
            case COMPANY:
            case COMPANY_SUB:
                return true;
            default:
                return false;
        }
    }
}
