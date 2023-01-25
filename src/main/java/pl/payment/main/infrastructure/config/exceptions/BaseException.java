package pl.payment.main.infrastructure.config.exceptions;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.payment.main.infrastructure.config.errorcode.ErrorCode;

import java.util.Map;
@Getter
@Slf4j
public class BaseException extends RuntimeException {

    private ErrorCode errorCode;

    public BaseException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        FormatException.withErrorCode(errorCode);
    }
    public BaseException(ErrorCode errorCode, Map <String, ?> params){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        FormatException.withErrorCodeAndMapOfParams(errorCode, params);

    }

}
