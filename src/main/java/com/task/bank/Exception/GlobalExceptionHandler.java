package com.task.bank.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoanEligibilityNotFoundException.class)
    public ResponseEntity<String> handleLoanEligibilityNotFoundException(LoanEligibilityNotFoundException ex) {
        // Returning a 404 response with the exception message
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    
    @ExceptionHandler(DebitCardEligibilityNotFoundException.class)
    public ResponseEntity<String> handleDebitCardEligibilityNotFoundException(DebitCardEligibilityNotFoundException ex) {
        // Return a custom message and HTTP status code when the exception is thrown
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
