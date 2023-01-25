package pl.payment.main.infrastructure.config.exceptions;

import pl.payment.main.infrastructure.config.errorcode.ErrorCode;

import java.util.Map;

public class UserException extends BaseException {

   public UserException(ErrorCode errorCode){

       super(errorCode);
    }
    public UserException(ErrorCode errorCode, Map<String,?> params){
       super(errorCode,params);
    }
}
