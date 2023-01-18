package pl.payment.main.infrastructure.config.exceptions;

import pl.payment.main.infrastructure.config.errorcode.ErrorCode;

public class UserException extends BaseException {

   public UserException(ErrorCode errorCode){
        super(errorCode);
    }
}
