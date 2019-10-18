package so.wwb.lotterybox.model.session;
/**
 * @author: wilson
 * @function: used for audit log control
 */
public class AuditLog {

    private String strOs;
    private String strBrowser;
    private String strIpAddr;
    private String strRequestType;

    public String getStrRequestUrl() {
        return strRequestUrl;
    }

    public void setStrRequestUrl(String strRequestUrl) {
        this.strRequestUrl = strRequestUrl;
    }

    private String strRequestUrl;

    public String getStrRequestType() {
        return strRequestType;
    }

    public void setStrRequestType(String strRequestType) {
        this.strRequestType = strRequestType;
    }

    public String getStrOs() {
        return strOs;
    }

    public void setStrOs(String strOs) {
        this.strOs = strOs;
    }

    public String getStrBrowser() {
        return strBrowser;
    }

    public void setStrBrowser(String strBrowser) {
        this.strBrowser = strBrowser;
    }

    public String getStrIpAddr() {
        return strIpAddr;
    }

    public void setStrIpAddr(String strIpAddr) {
        this.strIpAddr = strIpAddr;
    }
}
