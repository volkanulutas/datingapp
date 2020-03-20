package com.datingapp.login.responseDTO;


import java.io.Serializable;

/**
 * Datingapp on 20.03.2020
 *
 * @author volkanulutas
 */
public class LoginResponseDTO implements Serializable {

    private String token;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
