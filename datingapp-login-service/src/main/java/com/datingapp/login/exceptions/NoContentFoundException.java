package com.datingapp.login.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Datingapp on 20.03.2020
 *
 * @author volkanulutas
 */
public class NoContentFoundException extends RuntimeException {
    private ErrorResponse errorResponse;

    public NoContentFoundException(String message, String developerMessage) {
        super(message);
        errorResponse = new ErrorResponse();

        errorResponse.setDeveloperMsg(developerMessage);
        errorResponse.setErrorMsg(message);
        errorResponse.setResponseCode(HttpStatus.NO_CONTENT.value());
        errorResponse.setResponseStatus(HttpStatus.NO_CONTENT);
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
