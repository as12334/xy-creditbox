package so.wwb.lotterybox.model.session;

import so.wwb.lotterybox.model.common.annotations.Instructions;

import java.io.Serializable;
import java.util.Date;

public class UserSession<E> implements Serializable {
    @Instructions("sessionId")
    private String id;
    @Instructions("当前登录的玩家")
    private E user;
    @Instructions("Session 创建时间")
    private Date openTime;
    @Instructions("最后访问时间")
    private Date lastTime;
    @Instructions("导航地址")
    private String navigation;
    @Instructions("当前所在地址")
    private String currentAddress;
    private Long version;
    private Boolean duplicateLogin = false;

    public boolean isLogin() {
        return user != null;
    }

    public UserSession() {
        openTime = new Date();
    }

    public UserSession(String sessionId, String navigation) {
        this();
        this.id = sessionId;
        this.navigation = navigation;
    }

    public String getId() {
        return id;
    }

    public E getUser() {
        return user;
    }

    public void setUser(E user) {
        this.user = user;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public String getNavigation() {
        return navigation;
    }

    public void setNavigation(String navigation) {
        this.navigation = navigation;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public Boolean getDuplicateLogin() {
        return duplicateLogin;
    }

    public void setDuplicateLogin(Boolean duplicateLogin) {
        this.duplicateLogin = duplicateLogin;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
