package so.wwb.lotterybox.mdcenter.comet.websocket;

import org.soul.comet.websocket.model.SocketInfo;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.comet.vo.MessageVo;
import so.wwb.lotterybox.model.enums.base.SubSysCodeEnum;
import so.wwb.lotterybox.model.enums.user.UserTypeEnum;

import java.util.List;
import java.util.Set;

/**
 * 股东webSocket处理
 * @author marz
 * @time 2018-04-18 16:30:46
 */
public class ShareHolderWebSocketHandler extends LbWebSocketHandler {
    private static final Log LOG = LogFactory.getLog(ShareHolderWebSocketHandler.class);

    @Override
    public void sendMessage(MessageVo message) {
        List<String> userIdList = message.getUserIdList();
        Integer shareHolderId = message.getMasterId();
        if (CollectionTool.isNotEmpty(userIdList)  && shareHolderId != null) {
            LOG.debug("向指定股东后台{0}的在线登录用户ID{1}发送消息{2}", shareHolderId, userIdList, message);
            sendMessageToUsers(shareHolderId,userIdList,message);
        } else if (CollectionTool.isEmpty(userIdList) && shareHolderId != null) {
            LOG.debug("向指定股东后台{0}的所有在线登录用户发送消息{1}", shareHolderId,message);
            sendMessageToSite(shareHolderId, message);
        }else{
            LOG.debug("向所有股东后台的所有在线登录用户发送消息{0}", message);
            Set<Integer> siteIdList = getAllIdList();
            for (Integer id : siteIdList) {
                sendMessageToSite(id, message);
            }
        }
    }

    /**
     * 获取全部股东的id列表
     * @return
     */
    protected Set<Integer> getAllIdList() {
        return super.getAllIdList(SubSysCodeEnum.SHAREHOLDER.getCode());
    }

    /**
     * 只推送股东消息
     * @param socketInfo
     * @param messageVo
     * @return
     */
    @Override
    public boolean sessionCheck(SocketInfo socketInfo, MessageVo messageVo) {
        UserTypeEnum userType = EnumTool.enumOf(UserTypeEnum.class,socketInfo.getUserType());
        switch (userType){
            case SHAREHOLDER:
            case SHAREHOLDER_SUB:
                return true;
            default:
                return false;
        }
    }
}
