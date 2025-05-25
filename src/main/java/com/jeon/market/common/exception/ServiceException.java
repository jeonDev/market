package com.jeon.market.common.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {
    private final String code;
    private final String message;

    public ServiceException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceException(String code, String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }
}
