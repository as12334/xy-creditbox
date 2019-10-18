package so.wwb.lotterybox.web.tools;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:  wilson
 * @control: http servlet cookie control
 */
public class CookieTool {

    public static void addCookie(HttpServletResponse response, Map<String, String> cookieMap) {
        for (Map.Entry<String, String> entry : cookieMap.entrySet()) {
            Cookie cookie = new Cookie(entry.getKey(), entry.getValue());
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }

    public static void addCookie(HttpServletResponse response, String strName, String strValue) {
        Cookie cookie = new Cookie(strName, strValue);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    //expiredTime 有效期：分钟
    public static void addCookie(HttpServletResponse response, String strName, String strValue, Integer expiredTime) {
        Cookie cookie = new Cookie(strName, strValue);
        cookie.setMaxAge(expiredTime * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static Map<String, Cookie> getCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = getCookieMap(request);
        if (cookieMap.containsKey(name)) {
            return (Cookie) cookieMap.get(name);
        } else return null;
    }

    public static void editCookie(HttpServletRequest request, HttpServletResponse response, String strName, String strValue) {
        Cookie cookie = getCookieByName(request, strName);
        if (cookie != null) {
            cookie.setValue(strValue);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }

    public static void delCookie(HttpServletRequest request, HttpServletResponse response, String strName) {
        Cookie cookie = getCookieByName(request, strName);
        if (cookie != null) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }
}