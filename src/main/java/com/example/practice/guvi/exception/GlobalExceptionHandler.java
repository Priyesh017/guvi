package com.example.practice.guvi.exception;

import com.example.practice.guvi.dto.ErrorDetailsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 1. Catches Validation Failures (e.g., @NotNull, @Size, @Email violations)
     * Maps field names directly to their specific validation message.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetailsDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Loop through all validation failures and pluck out field name + message
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ErrorDetailsDto ErrorDetailsDto = new ErrorDetailsDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Validation Failed",
                errors // Pass the map containing your exact field errors
        );

        return new ResponseEntity<>(ErrorDetailsDto, HttpStatus.BAD_REQUEST);
    }

    /**
     * 2. Catches Standard Business Violations (e.g., IllegalArgumentException)
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDetailsDto> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorDetailsDto ErrorDetailsDto = new ErrorDetailsDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage()
        );
        return new ResponseEntity<>(ErrorDetailsDto, HttpStatus.BAD_REQUEST);
    }

    /**
     * 3. Ultimate Fallback (Catches system panics like NullPointerExceptions)
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetailsDto> handleGlobalException(Exception ex) {
        ErrorDetailsDto ErrorDetailsDto = new ErrorDetailsDto(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                ex.getMessage()
        );
        return new ResponseEntity<>(ErrorDetailsDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
