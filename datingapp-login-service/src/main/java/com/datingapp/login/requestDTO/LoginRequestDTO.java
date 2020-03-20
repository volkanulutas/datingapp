package com.datingapp.login.requestDTO;

import java.io.Serializable;

/**
 * Datingapp on 20.03.2020
 *
 * @author volkanulutas
 */
public class LoginRequestDTO implements Serializable {
    private String userCredential;

    private String password;

    private Long subDepartmentId;

    public LoginRequestDTO() {
    }

    public String getUserCredential() {
        return userCredential;
    }

    public void setUserCredential(String userCredential) {
        this.userCredential = userCredential;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getSubDepartmentId() {
        return subDepartmentId;
    }

    public void setSubDepartmentId(Long subDepartmentId) {
        this.subDepartmentId = subDepartmentId;
    }
}
