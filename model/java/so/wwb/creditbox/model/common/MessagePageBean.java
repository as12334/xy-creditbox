package so.wwb.creditbox.model.common;

import java.io.Serializable;

/**
 * Created by block on 2019/12/27.
 */
public class MessagePageBean implements Serializable{

    private static final long serialVersionUID = 6881144400826316849L;
    protected String cssClass = "";
    protected String isback = "1";
    protected String isSuccess = "";
    protected String msgCode = "";
    protected String msgText = "";
    protected String openwindow = "";
    protected String skin = "";
    protected String url = "";

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getIsback() {
        return isback;
    }

    public void setIsback(String isback) {
        this.isback = isback;
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public String getOpenwindow() {
        return openwindow;
    }

    public void setOpenwindow(String openwindow) {
        this.openwindow = openwindow;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
