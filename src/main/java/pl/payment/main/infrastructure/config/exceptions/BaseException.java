package pl.payment.main.infrastructure.config.exceptions;

import lombok.extern.slf4j.Slf4j;
import pl.payment.main.infrastructure.config.errorcode.ErrorCode;

@Slf4j
public class BaseException extends RuntimeException {

    private ErrorCode errorCode;

    public BaseException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
        FormatException.withErrorCode(errorCode);
    }
}
