package so.wwb.creditbox.common.exceptions;

import org.soul.commons.exception.CustomRuntimeException;

public class CryptException extends CustomRuntimeException {
    public CryptException() {
    }

    public CryptException(String message, Throwable e) {
        super(e, message);
    }

    public CryptException(String message, Object... args) {
        super(message, args);
    }

    public CryptException(Throwable cause, String message, Object... args) {
        super(cause, message, args);
    }

    public CryptException(Throwable cause, boolean log, String message, Object... args) {
        super(cause, log, message, args);
    }

    public CryptException(Throwable e) {
        super(e);
    }
}
