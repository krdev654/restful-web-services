package com.sample.mydash.contoller;

import com.sample.mydash.model.ErrorResponse;
import com.sample.mydash.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedExceptionResponseEntity extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class, UserNotFoundException.class})
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        if (ex instanceof UserNotFoundException) {
            statusCode = HttpStatus.NOT_FOUND;
        }

        ErrorResponse errorResponse =
                new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse =
                new ErrorResponse(new Date(), "Validation Failed", ex.getBindingResult().toString());
        return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
