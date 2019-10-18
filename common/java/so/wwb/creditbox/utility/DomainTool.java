package so.wwb.creditbox.utility;

import javax.servlet.http.HttpServletRequest;

public class DomainTool {
    public static String getDomain(HttpServletRequest request) {
        String domain = request.getServerName();
        if (domain.startsWith("www.")) {
            domain = domain.substring(4);
        } else if (domain.startsWith("m.")) {
            domain = domain.substring(2);
        } else if (domain.startsWith("android.")) {
            domain = domain.substring("android.".length());
        } else if (domain.startsWith("ios.")) {
            domain = domain.substring("ios.".length());
        }
        return domain;
    }
}
