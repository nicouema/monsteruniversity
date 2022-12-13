package ar.com.nicouema.monsteruniversity.common.exception.handler;

import ar.com.nicouema.monsteruniversity.common.exception.NotFoundException;
import ar.com.nicouema.monsteruniversity.common.exception.error.ErrorCode;
import ar.com.nicouema.monsteruniversity.common.exception.error.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public final class GlobalExceptionHandler{

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ErrorDetails> handleNotFound(NotFoundException ex) {

        ErrorDetails error = ErrorDetails.builder()
                .code(ErrorCode.RESOURCE_NOT_FOUND)
                .detail("The resource with id %s is not found.".formatted(ex.getResourceId()))
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
