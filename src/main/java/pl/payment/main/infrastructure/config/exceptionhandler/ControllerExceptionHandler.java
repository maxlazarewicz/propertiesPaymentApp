package pl.payment.main.infrastructure.config.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import pl.payment.main.infrastructure.config.exceptions.UserException;

import java.util.Date;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleException
            (Exception exception, WebRequest request){
                ErrorMessage em = new ErrorMessage(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        new Date(),
                        exception.getMessage(),
                        request.getDescription(false)
                );
                return new ResponseEntity(em, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = UserException.class)
    public ResponseEntity handleUserException
            (UserException userException, WebRequest request){
        ErrorMessage em = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                userException.getErrorCode().getCode(),
                new Date(),
                userException.getMessage(),
                request.getDescription(false)
        );
        userException.printStackTrace();
        return new ResponseEntity(em, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
