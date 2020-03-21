package com.datingapp.authdemo.exceptions;


import org.springframework.http.HttpStatus;

/**
 * Datingapp on 21.03.2020
 *
 * @author volkanulutas
 */
public class DataDuplicationException extends RuntimeException {
    private ErrorResponse errorResponse;

    public DataDuplicationException(String message, String developerMessage) {
        super(message);
        errorResponse = new ErrorResponse(message, developerMessage, HttpStatus.CONFLICT, HttpStatus.CONFLICT.value());
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
