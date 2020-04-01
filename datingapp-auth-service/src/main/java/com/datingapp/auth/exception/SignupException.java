package com.datingapp.auth.exception;

import lombok.*;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SignupException extends RuntimeException {

    private ErrorResponse errorResponse;
}

