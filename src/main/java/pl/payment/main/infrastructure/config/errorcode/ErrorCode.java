package pl.payment.main.infrastructure.config.errorcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND_MESSAGE(1, "Entity User with specified id not found"),
    LEAD_STATUS_NOT_FOUND_MESSAGE(2, "Entity Lead Status with specified id not found"),
    PROPERTY_NOT_FOUND_MESSAGE(3,"Entity Property with specified id not found"),
    LEAD_NOT_FOUND_MESSAGE(4,"Entity Lead with specified id not found"),
    ROLE_NOT_FOUND_MESSAGE(5, "Entity Role with specified id not found");


    private final int code;
    private final String message;

}
