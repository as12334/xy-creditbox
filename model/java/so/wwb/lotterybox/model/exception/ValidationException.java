package so.wwb.lotterybox.model.exception;

import org.soul.commons.exception.CustomRuntimeException;

public class ValidationException extends CustomRuntimeException {

    public ValidationException(String message, Object... args) {
        super(message, args);
    }

}
