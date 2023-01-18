package pl.payment.main.infrastructure.config.exceptions;

import lombok.extern.slf4j.Slf4j;
import pl.payment.main.infrastructure.config.errorcode.ErrorCode;

@Slf4j
public class BaseException extends Exception {

    private ErrorCode errorCode;
    
}
