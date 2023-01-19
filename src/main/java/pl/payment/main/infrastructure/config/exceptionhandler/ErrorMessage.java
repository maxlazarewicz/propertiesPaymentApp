package pl.payment.main.infrastructure.config.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
@AllArgsConstructor
@Getter
public class ErrorMessage {

    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
}
