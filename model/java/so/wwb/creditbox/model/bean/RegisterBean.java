package so.wwb.creditbox.model.bean;

import java.io.Serializable;

/**
 * Created by jeremy on 18-1-22.
 */
public class RegisterBean implements Serializable {
    private static final long serialVersionUID = -8120384051968888922L;
    /**昵称*/
    private String nickname;
    /**账户名*/
    private String username;
    /**密码*/
    private String password;
    /**确认密码*/
    private String confirmPassword;
    /**用户类型 参考 UserTypeEnum 和 PlayerTypeEnum*/
    private String userType;
    /**y验证码*/
    private String VerificationCode;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getVerificationCode() {
        return VerificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        VerificationCode = verificationCode;
    }
}
