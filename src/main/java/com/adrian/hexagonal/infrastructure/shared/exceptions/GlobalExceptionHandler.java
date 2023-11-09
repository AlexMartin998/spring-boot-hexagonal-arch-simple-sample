package com.adrian.hexagonal.infrastructure.shared.exceptions;

import com.adrian.hexagonal.domain.exceptions.BadRequestException;
import com.adrian.hexagonal.domain.exceptions.ResourceNotFoundException;
import com.adrian.hexagonal.infrastructure.shared.dto.ErrorDetailsDto;
import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


// Handler de TODAS las exceptions de nuestra App. -- basta con esto, ya NOO necesita mas nada, ni ser importado ni notificado a Spring
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {  // extends para crear el handler del @Valid


    // // Bad request exception
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDetailsDto> handlerBadRequestException(BadRequestException exception, WebRequest webRequest) {
        return createErrorResponse(exception, exception.getMessage(), HttpStatus.BAD_REQUEST, webRequest);
    }

    // // Resource Not Found Exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetailsDto> handlerResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        return createErrorResponse(exception, exception.getMessage(), HttpStatus.NOT_FOUND, webRequest);
    }


    // // Default Exception (for ALL others)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetailsDto> handlerGlobalException(Exception exception, WebRequest webRequest) {
        return createErrorResponse(exception, exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
    }


    // // Spring Validation (@Valid): handler de los errors del @Valid <- BindingResult
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatusCode status,
            @NonNull WebRequest request
    ) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(err -> {
            String fieldName = ((FieldError) err).getField();
            String message = err.getDefaultMessage();

            errors.put(fieldName, message);
        });

        return new ResponseEntity<>(errors, status);
    }


    private ResponseEntity<ErrorDetailsDto> createErrorResponse(Exception exception, String message, HttpStatus httpStatus, WebRequest webRequest) {
        ErrorDetailsDto errorDetails = ErrorDetailsDto.builder()
                .timeStamp(new Date())
                .message(message)
                .details(webRequest.getDescription(false))
                .build();

        return new ResponseEntity<>(errorDetails, httpStatus);
    }

}
