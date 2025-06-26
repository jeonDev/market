package com.jeon.market.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServiceException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    public ServiceException(String code, String message) {
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.code = code;
        this.message = message;
    }

    public ServiceException(String code, String message, Throwable cause) {
        super(cause);
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.code = code;
        this.message = message;
    }

    public ServiceException(ErrorType errorType) {
        this.httpStatus = errorType.getHttpStatus();
        this.code = errorType.getCode();
        this.message = errorType.getMessage();
    }

    public ServiceException(ErrorType errorType, Object... parameters) {
        this.httpStatus = errorType.getHttpStatus();
        this.code = errorType.getCode();
        this.message = String.format(errorType.getMessage(), parameters);
    }
}
