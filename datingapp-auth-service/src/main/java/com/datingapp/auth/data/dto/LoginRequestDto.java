package com.datingapp.auth.data.dto;

import java.io.Serializable;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public class LoginRequestDto implements Serializable {
    private String username;

    private String password;

    public LoginRequestDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
