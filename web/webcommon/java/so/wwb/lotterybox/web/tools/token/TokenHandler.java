package so.wwb.lotterybox.web.tools.token;

import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import so.wwb.lotterybox.web.tools.SessionManagerCommon;

import java.util.*;

public class TokenHandler {
    public static final String DEFAULT_TOKEN_NAME = "lb.token";
    public static final String TOKEN_VALUE = "token";
    private static final Integer EFFECIVETIME = 5;
    static Map<String, Object[]> lb_token = null;

    private static String generateToken() {
        return UUID.randomUUID().toString();
    }

    public static String generateGUID() {
        Object object = SessionManagerCommon.getSpringMvcToken();
        String token = generateToken();
        if (object != null) {
            lb_token = (Map<String, Object[]>)object;
            Iterator<Map.Entry<String,Object[]>> entries = lb_token.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String,Object[]> entry = entries.next();
                Object[] value = entry.getValue();
                Date effeciveTime = DateTool.addMinutes((Date) value[0],EFFECIVETIME);
                if (DateTool.millisecondsBetween(SessionManagerCommon.getDate().getNow(),effeciveTime) >0) {
                    entries.remove();
                }
            }
        } else {
            lb_token = new HashMap<String, Object[]>();
        }
        Object[] tokenValues = new Object[2];
        tokenValues[0] = SessionManagerCommon.getDate().getNow();
        tokenValues[1] = token;
        lb_token.put(DEFAULT_TOKEN_NAME + "." + token,tokenValues);
        SessionManagerCommon.setSpringMvcToken(lb_token);
        return token;
    }

    public static boolean validClientToken(String clientToken) {
        return !StringTool.isBlank(clientToken);
    }

    public static boolean validServerToken(String serverToken) {
        return !StringTool.isBlank(serverToken);
    }

    public synchronized static boolean isRepeat(String clientToken) {
        Map<String,Object[]> sessionTokenMap = (Map<String,Object[]>)SessionManagerCommon.getSpringMvcToken();
        if (sessionTokenMap != null) {
            Object[] values = sessionTokenMap.get(DEFAULT_TOKEN_NAME + "." +clientToken);
            if (values != null && clientToken.equals(values[1])) {
                sessionTokenMap.remove(DEFAULT_TOKEN_NAME + "." +clientToken);
                SessionManagerCommon.setSpringMvcToken(sessionTokenMap);
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

}
