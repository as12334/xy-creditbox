package so.wwb.lotterybox.web.shiro.local.authc;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.soul.commons.cache.CacheKey;

public class LocalToken extends UsernamePasswordToken {

    public static final String DEFAULT_USERNAME_PARAM = FormAuthenticationFilter.DEFAULT_USERNAME_PARAM;
    public static final String DEFAULT_PASSWORD_PARAM = FormAuthenticationFilter.DEFAULT_PASSWORD_PARAM;
    public static final String DEFAULT_REMEMBER_ME_PARAM = FormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM;
    public static final String DEFAULT_CAPTCHA_PARAM = "";

    /**
     * 用户ID
     *
     */
    private Integer id;

    /**
     * 验证码
     */
    private String captcha;


    /**
     * 身份验证码
     */
    private String authentication;

    /**
     * 登录类型
     */
    private Integer entrance;
    private AuthenticationException authenticationException;
    private Integer siteId;
    private String userType;
    /**
     * 登入令牌
     */
    private String token;

    public LocalToken(String username, String md5, boolean rememberMe, String host) {
        super(username,md5,rememberMe,host);
    }

    public LocalToken() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public Integer _getEntrance() {
        return entrance;
    }

    public void _setEntrance(Integer entrance) {
        this.entrance = entrance;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return CacheKey.getCacheKey(
                siteId+""
                , userType
                , super.getPrincipal().toString()
                , getId()+"");
    }

    public AuthenticationException getAuthenticationException() {
        return authenticationException;
    }

    public void setAuthenticationException(AuthenticationException authenticationException) {
        this.authenticationException = authenticationException;
    }
}
