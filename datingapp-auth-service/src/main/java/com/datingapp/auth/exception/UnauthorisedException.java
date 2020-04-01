package com.datingapp.auth.exception;

import org.springframework.http.HttpStatus;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public class UnauthorisedException extends RuntimeException {
    private ErrorResponse errorResponse;

    public UnauthorisedException(String message, String developerMessage) {
        super(message);
        errorResponse = new ErrorResponse();

        errorResponse.setDeveloperMsg(developerMessage);
        errorResponse.setErrorMsg(message);
        errorResponse.setResponseCode(HttpStatus.UNAUTHORIZED.value());
        errorResponse.setResponseStatus(HttpStatus.UNAUTHORIZED);
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}

