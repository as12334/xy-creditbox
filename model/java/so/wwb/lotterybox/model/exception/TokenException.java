package so.wwb.lotterybox.model.exception;

import javax.security.auth.login.LoginException;

public class TokenException  extends LoginException{
    private static final long serialVersionUID = -2112878680072211787L;

    public TokenException(String msg) {
        super(msg);
    }
}
