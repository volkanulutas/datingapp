package com.datingapp.authdemo.dto.response;


import java.io.Serializable;

/**
 * Datingapp on 21.03.2020
 *
 * @author volkanulutas
 */
public class AdminResponseDTO implements Serializable {

    private String emailAddress;

    private Long id;

    private String password;

    private Character status;

    private Integer loginAttempt;

    public AdminResponseDTO() {
    }

    public AdminResponseDTO(String emailAddress, Long id, String password, Character status, Integer loginAttempt) {
        this.emailAddress = emailAddress;
        this.id = id;
        this.password = password;
        this.status = status;
        this.loginAttempt = loginAttempt;
    }

    public AdminResponseDTO(String emailAddress, long id) {
        this.emailAddress = emailAddress;
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Integer getLoginAttempt() {
        return loginAttempt;
    }

    public void setLoginAttempt(Integer loginAttempt) {
        this.loginAttempt = loginAttempt;
    }
}
