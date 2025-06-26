package com.jeon.market.common.exception;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Hidden // swagger 충돌로 인해 추가
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validException(final MethodArgumentNotValidException e) {
        log.error("[GlobalException] Endpoint 검증 오류 : {}", e.getMessage());
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        ErrorResponse.of("V0", message)
                );
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponse> serviceException(final ServiceException e) {
        log.error("[GlobalException] Service 오류 : {}", e.getMessage());
        return ResponseEntity.status(e.getHttpStatus())
                .body(
                        ErrorResponse.of(e.getCode(), e.getMessage())
                );
    }
}
