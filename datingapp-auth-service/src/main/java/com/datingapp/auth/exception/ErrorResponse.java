package com.datingapp.auth.exception;

import lombok.*;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse implements Serializable {

    private String errorMsg;

    private String developerMsg;

    private HttpStatus responseStatus;

    private int responseCode;

    public ErrorResponse(String errorMsg, String developerMsg) {
        this.errorMsg = errorMsg;
        this.developerMsg = developerMsg;
    }
}



