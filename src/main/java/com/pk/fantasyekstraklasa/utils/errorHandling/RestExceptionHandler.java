package com.pk.fantasyekstraklasa.utils.errorHandling;

import com.pk.fantasyekstraklasa.utils.errorHandling.customExceptions.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.support.ExceptionMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException ex, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName() + " " +
                    violation.getPropertyPath() + ": " + violation.getMessage());
        }

        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseBody
    public ResponseEntity<Object> handleDataIntegrityViolationException(Exception e) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT, e.getLocalizedMessage(), "User with this email already exists");
        return new ResponseEntity<>(apiError,apiError.getStatus());
    }

}
