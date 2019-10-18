package so.wwb.lotterybox.web.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * @author:wilson
 * @function:session control by shiro
 */
public class SessionUserListener implements SessionListener {
    private static final OnLineUserBase onLineUserBase = new OnLineUserBase();

    public static OnLineUserBase getInstance() {
        return onLineUserBase;
    }

    @Override
    public void onStart(Session session) {

    }

    @Override
    public void onStop(Session session) {
        SessionUserListener.getInstance().removeOnLineLoginUser(session);
    }

    @Override
    public void onExpiration(Session session) {
        SessionUserListener.getInstance().removeOnLineLoginUser(session);
    }
}