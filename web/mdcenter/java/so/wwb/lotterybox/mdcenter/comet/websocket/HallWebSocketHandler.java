package so.wwb.lotterybox.mdcenter.comet.websocket;

import org.soul.comet.websocket.model.SocketInfo;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.comet.vo.MessageVo;
import so.wwb.lotterybox.model.enums.user.UserTypeEnum;

import java.util.List;
import java.util.Set;

public class HallWebSocketHandler extends LbWebSocketHandler {
    private static final Log LOG = LogFactory.getLog(HallWebSocketHandler.class);

    @Override
    public void sendMessage(MessageVo message) {
        List<String> userIdList = message.getUserIdList();
        Integer siteId = message.getSiteId();
        Integer shareHolderId = message.getMasterId();
        if (CollectionTool.isNotEmpty(userIdList) && siteId != null) {
            LOG.debug("向商户{0}的游戏中心指定的在线登录用户ID{1}发送消息{2}", siteId, userIdList, message);
            sendMessageToUsers(siteId,userIdList,message);
        }else if(CollectionTool.isEmpty(userIdList) && siteId != null){
            LOG.debug("向商户{0}的游戏中心指定的在线登录用户ID{1}发送消息{2}", siteId, userIdList, message);
            sendMessageToSite(siteId, message);
        }else if(shareHolderId != null){
            Set<Integer> siteIds = getSiteIdByShareHolderId(shareHolderId);
            LOG.debug("向指定股东{0}的所有商户{1}的对应的所有在线登录用户发送消息{2}", shareHolderId,siteIds,message);
            for (Integer itemSiteId : siteIds) {
                sendMessageToSite(itemSiteId,message);
            }
        }else{
            LOG.debug("向所有在线登录用户发送消息{0}", message);
            sendMessageToAll(message);
        }
    }

    /**
     * 只推送玩家消息
     * @param socketInfo
     * @param messageVo
     * @return
     */
    @Override
    public boolean sessionCheck(SocketInfo socketInfo, MessageVo messageVo) {
        UserTypeEnum userType = EnumTool.enumOf(UserTypeEnum.class,socketInfo.getUserType());
        switch (userType){
            case PLAYER:
                return true;
            default:
                return false;
        }
    }
}
