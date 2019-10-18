package so.wwb.lotterybox.mdcenter.comet.websocket;

import org.soul.comet.websocket.model.SocketInfo;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.enums.EnumTool;
import org.soul.model.comet.vo.MessageVo;
import so.wwb.lotterybox.model.constants.common.Const;
import so.wwb.lotterybox.model.enums.user.UserTypeEnum;

import java.util.List;

public class BossWebSocketHandler extends LbWebSocketHandler {

    @Override
    public void sendMessage(MessageVo message) {
        List<String> userIdList = message.getUserIdList();
        if(CollectionTool.isNotEmpty(userIdList)){
            LOG.debug("给boss站点指定的在线登录用户ID{0}发送消息{1}", userIdList, message);
            sendMessageToUsers(Const.BOSS_DATASOURCE_ID,userIdList,message);
        }else{
            LOG.debug("给boss站点的所有在线登录用户发送消息{0}", message);
            sendMessageToSite(Const.BOSS_DATASOURCE_ID,message);
        }
    }

    /**
     * 只推送总控消息
     * @param socketInfo
     * @param messageVo
     * @return
     */
    @Override
    public boolean sessionCheck(SocketInfo socketInfo, MessageVo messageVo) {
        UserTypeEnum userType = EnumTool.enumOf(UserTypeEnum.class,socketInfo.getUserType());
        switch (userType){
            case BOSS:
            case BOSS_SUB:
                return true;
            default:
                return false;
        }
    }
}
