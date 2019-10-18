package so.wwb.lotterybox.model.manager.user.vo;

/**
 * Created by cj on 15-8-24.
 */
public class UpdatePasswordVo {
    private String password;
    private String newPassword;
    private String newRePassword;

    private String privilegePwd;
    private String privilegeRePwd;
    private String loginPwd;
    private String passwordLevel;

    private String oldPrivilegePwd;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewRePassword() {
        return newRePassword;
    }

    public void setNewRePassword(String newRePassword) {
        this.newRePassword = newRePassword;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getPrivilegePwd() {
        return privilegePwd;
    }

    public void setPrivilegePwd(String privilegePwd) {
        this.privilegePwd = privilegePwd;
    }

    public String getPrivilegeRePwd() {
        return privilegeRePwd;
    }

    public void setPrivilegeRePwd(String privilegeRePwd) {
        this.privilegeRePwd = privilegeRePwd;
    }

    public String getPasswordLevel() {
        return passwordLevel;
    }

    public void setPasswordLevel(String passwordLevel) {
        this.passwordLevel = passwordLevel;
    }

    public String getOldPrivilegePwd() {
        return oldPrivilegePwd;
    }

    public void setOldPrivilegePwd(String oldPrivilegePwd) {
        this.oldPrivilegePwd = oldPrivilegePwd;
    }
}
