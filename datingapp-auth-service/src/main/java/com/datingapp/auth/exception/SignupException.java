package com.datingapp.auth.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

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
public class SignupException extends RuntimeException {

    private ErrorResponse errorResponse;
}

