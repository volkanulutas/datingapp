package com.datingapp.auth.exceptionHandler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Datingapp on 19.03.2020
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
        errorResponse.setStatus(HttpStatus.UNAUTHORIZED);
    }
}

