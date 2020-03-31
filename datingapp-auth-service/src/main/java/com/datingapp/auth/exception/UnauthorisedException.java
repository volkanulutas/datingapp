package com.datingapp.auth.exception;

import lombok.*;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Getter
@Setter
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UnauthorisedException extends RuntimeException {
    private ErrorResponse errorResponse;

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}

