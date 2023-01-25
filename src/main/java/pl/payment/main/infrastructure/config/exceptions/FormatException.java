package pl.payment.main.infrastructure.config.exceptions;

import lombok.extern.slf4j.Slf4j;
import pl.payment.main.infrastructure.config.errorcode.ErrorCode;

import java.util.Map;

@Slf4j
public class FormatException {

    public static void withErrorCode(ErrorCode errorCode) {
        log.error(
                new StringBuilder()
                        .append("Error Code: ")
                        .append(errorCode.getCode())
                        .append(" ,with message: ")
                        .append(errorCode.getMessage()).toString()
        );
    }
    public static void withErrorCodeAndMapOfParams(ErrorCode errorCode, Map<String, ?> params){
        log.error(
                new StringBuilder()
                        .append("Error Code: ")
                        .append(errorCode.getCode())
                        .append(" ,with message: ")
                        .append(errorCode.getMessage()).toString()
        );

        params.forEach((k,v) -> log.error("Key: " + k + " Value: " + v));
    }
}
