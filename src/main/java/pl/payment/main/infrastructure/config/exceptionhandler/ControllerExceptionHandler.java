package pl.payment.main.infrastructure.config.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = InvalidDataAccessApiUsageException.class)
    public ResponseEntity handleInvalidDataAccessApiUsageException
            (InvalidDataAccessApiUsageException exception, WebRequest request){
                ErrorMessage em = new ErrorMessage(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        new Date(),
                        exception.getMessage(),
                        request.getDescription(false)
                );
                return new ResponseEntity(em, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
