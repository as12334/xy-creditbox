package so.wwb.lotterybox.model.manager.user.vo;

import org.soul.model.passport.vo.PassportVo;

/**
 * 开放中心访问时传递参数.
 * @author alvin
 * @date 2017.07.07
 */
public class TokenPassportVo extends PassportVo {
    private String token;
    private String hallUri;
    private String payUri;
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHallUri() {
        return hallUri;
    }

    public void setHallUri(String hallUri) {
        this.hallUri = hallUri;
    }

    public String getPayUri() {
        return payUri;
    }

    public void setPayUri(String payUri) {
        this.payUri = payUri;
    }
}
