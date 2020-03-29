package com.datingapp.auth.exception;

import org.springframework.http.HttpStatus;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public class SignupException extends RuntimeException {
    private ErrorResponse errorResponse;

    public SignupException(String message, String developerMessage) {
        super(message);
        errorResponse = new ErrorResponse();

        errorResponse.setDeveloperMsg(developerMessage);
        errorResponse.setErrorMsg(message);
        errorResponse.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}

