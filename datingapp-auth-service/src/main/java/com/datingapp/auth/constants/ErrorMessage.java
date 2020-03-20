package com.datingapp.auth.constants;

/**
 * Datingapp on 19.03.2020
 *
 * @author volkanulutas
 */
public class ErrorMessage {

    public interface TokenInvalid {
        String DEVELOPER_MESSAGE= "Request not authorized.";
        String MESSAGE ="Unmatched JWT token.";
    }
}
