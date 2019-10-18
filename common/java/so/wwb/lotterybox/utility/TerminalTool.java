package so.wwb.lotterybox.utility;

import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Create by Fei on 2018-02-14
 */
public class TerminalTool {
    private static final Log LOG = LogFactory.getLog(TerminalTool.class);

    /**
     * 获取终端标志
     */
    public static boolean isApp(HttpServletRequest request) {
        String ua = request.getHeader("User-Agent");
        if (StringTool.isNotBlank(ua)) {
            return ua.contains("app_android") || ua.contains("app_ios");
        }
        return false;
    }
//
//    /**
//     * 获取终端标志
//     */
//    public static String getOrigin(HttpServletRequest request) {
//        String ua = request.getHeader("User-Agent");
//        LOG.info("终端工具 -> user-agent = {0}", ua);
//        if (StringTool.isNotBlank(ua) &&
//                (ua.toLowerCase().contains("android") || ua.contains("ios")
//                        || ua.contains("iPhone")|| ua.contains("iPad")) || ua.equals(OriginEnum.MOBILE.getCode())) {
//            return OriginEnum.MOBILE.getCode();
//        }
//        return OriginEnum.PC.getCode();
//    }

    public static String getTerminal(HttpServletRequest request) {
        String ua = request.getHeader("User-Agent");
        if (StringTool.isNotBlank(ua)) {
            if (ua.contains("app_android")) {
                return "安卓 APP";
            } else if (ua.contains("app_ios")) {
                return "IOS APP";
            } else if (ua.contains("Android")) {
                return "安卓 H5";
            } else if (ua.contains("iPhone") || ua.contains("iPad")) {
                return "IOS H5";
            } else {
                return "PC";
            }
        }
        return "未知UA=" + ua;
    }

}
