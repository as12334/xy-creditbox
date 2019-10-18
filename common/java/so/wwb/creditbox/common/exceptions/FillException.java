package so.wwb.creditbox.common.exceptions;

import org.soul.commons.exception.CustomRuntimeException;

public class FillException extends CustomRuntimeException {
    public FillException() {
    }

    public FillException(String message, Throwable e) {
        super(e, message);
    }

    public FillException(String message, Object... args) {
        super(message, args);
    }

    public FillException(Throwable cause, String message, Object... args) {
        super(cause, message, args);
    }

    public FillException(Throwable cause, boolean log, String message, Object... args) {
        super(cause, log, message, args);
    }

    public FillException(Throwable e) {
        super(e);
    }
}
