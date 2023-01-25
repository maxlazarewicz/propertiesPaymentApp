package pl.payment.main.infrastructure.config.exceptionhandler;


import lombok.Getter;
import java.util.Date;
@Getter
public class ErrorMessage {

    private int httpErrorCode;

    private int internalErrorCode;
    private Date timestamp;
    private String message;
    private String description;

    public ErrorMessage(int httpErrorCode, Date timestamp, String message, String description) {
        this.httpErrorCode = httpErrorCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

    public ErrorMessage(int httpErrorCode, int internalErrorCode, Date timestamp, String message, String description) {
        this.httpErrorCode = httpErrorCode;
        this.internalErrorCode = internalErrorCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }
}
