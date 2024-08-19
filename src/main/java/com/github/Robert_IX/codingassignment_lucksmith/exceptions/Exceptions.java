package com.github.Robert_IX.codingassignment_lucksmith.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for the application.
 * This class handles different types of exceptions thrown by the application
 * and returns appropriate HTTP responses with specific status codes.
 *
 * This ensures that the application provides meaningful error messages
 * and HTTP statuses in response to various exceptions.
 *
 * @author Robert Gheorghe
 */
@ControllerAdvice
public class Exceptions
{

    /**
     * Handles all generic exceptions and returns a 500 Internal Server Error response.
     *
     * @param e the exception that was thrown
     * @return ResponseEntity with the error message and HTTP status 500
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    /**
     * Handles IllegalArgumentException and returns a 400 Bad Request response.
     *
     * @param e the IllegalArgumentException that was thrown
     * @return ResponseEntity with the error message and HTTP status 400
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}