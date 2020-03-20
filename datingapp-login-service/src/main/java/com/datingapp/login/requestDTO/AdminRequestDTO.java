package com.datingapp.login.requestDTO;


import java.io.Serializable;

/**
 * Datingapp on 20.03.2020
 *
 * @author volkanulutas
 */
public class AdminRequestDTO implements Serializable {
    private String username;
    private String emailAddress;

    public AdminRequestDTO() {
    }

    public AdminRequestDTO(String username, String emailAddress) {
        this.username = username;
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
