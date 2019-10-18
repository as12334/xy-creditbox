package so.wwb.lotterybox.web.session;

import org.apache.shiro.session.Session;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.session.SessionKey;
import so.wwb.lotterybox.common.dubbo.ServiceTool;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:wilson
 * @function:session_online_user_control
 */
public class OnLineUserBase {
    private Log log = LogFactory.getLog(OnLineUserBase.class);

    //region warning: can not delete
    /*
    private Map<Serializable, Session> onLineLoginUserMap = new HashMap<>();
    public Map<Serializable, Session> getOnLineLoginUserMap() {
        return onLineLoginUserMap;
    }*/
    //endregion

    public void addOnLineLoginUser(Session session) {

        //region warning: can not delete
        /*
        if (!onLineLoginUserMap.containsKey(session.getId())) {
            onLineLoginUserMap.put(session.getId(), session);
        }
        */
        //endregion

        this.handleOnlineUser(session, "1");
    }

    public void removeOnLineLoginUser(Session session) {

        //region warning: can not delete
        /*
        if (null == session) return;
        if (onLineLoginUserMap.containsKey(session.getId())) {
            onLineLoginUserMap.remove(session.getId());
        }
        */
        //endregion

        this.handleOnlineUser(session, "0");
    }

    private void handleOnlineUser(Session session, String strOnlineStatus) {
        if (null == session) {
            log.error("one line user control: current session is empty");
            return;
        }

        Object siteId = session.getAttribute(SessionKey.S_SITE_ID);
        Object userId = session.getAttribute(SessionKey.S_USER_ID);
        if (null == siteId || null == userId) {
            log.error("can not get siteId or userId from this session, session Id: {0}", session.getId());
            return;
        }

        try {
            Map<String, String> map = new HashMap<>();
//            map.put(UserPlayer.PROP_ONLINE_STATUS, strOnlineStatus);
//            UserPlayerVo vo = new UserPlayerVo();
//            vo.getSearch().setId(Integer.parseInt(userId.toString()));
//            vo.getSearch().setMap(map);
//            ServiceTool.userPlayerService().updatePlayerByUserId(vo);
            log.info("update user {0} at site {1} status to {2} finished", userId, siteId, strOnlineStatus);
        } catch (Exception e) {
            log.error("update user {0} at site {1} status to {2} occur exception, refer to:{3}", userId, siteId, strOnlineStatus, e);
        }
    }
}
