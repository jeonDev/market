package com.jeon.market.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {
    // COMMON
    DATA_EMPTY_INPUT(HttpStatus.BAD_REQUEST, "0001", "%s is Empty"),
    ENTITY_EMPTY(HttpStatus.BAD_REQUEST, "404", "Data is Empty"),

    // MEMBER
    LOGIN_PASSWORD_UNMATCHED(HttpStatus.BAD_REQUEST, "1001", "Password UnMatch"),
    LOGIN_PASSWORD_EMPTY(HttpStatus.BAD_REQUEST, "1002", "Password Empty"),
    LOGIN_PASSWORD_WRONG_COUNT_MAX(HttpStatus.BAD_REQUEST, "1003", "Password Wrong Count Max")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    ErrorType(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
