package com.datingapp.authdemo.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Datingapp on 21.03.2020
 *
 * @author volkanulutas
 */
@ApiModel(value = "This is admin request class")
public class AdminRequestDTO implements Serializable {

    @ApiModelProperty(value = "This is the id of admin")
    private Long id;

    @ApiModelProperty(value = "This is the username of admin")
    private String username;

    @ApiModelProperty(value = "This is full name of admin")
    private String fullName;

    @ApiModelProperty(value = "This is the email address of admin")
    private String emailAddress;

    @ApiModelProperty(value = "This is the status of admin")
    private Character status;

    @ApiModelProperty(value = "This represents the profile and its respective user menus" +
            " that this admin has access to")
    private Long profileId;

    @ApiModelProperty(value = "This checks if email has been sent")
    private Character emailSent;

    @ApiModelProperty(value = "This is the password of admin")
    private String password;

    public AdminRequestDTO() {
    }

    public AdminRequestDTO(Long id, String username, String fullName,
                           String emailAddress, Character status,
                           Long profileId, Character emailSent, String password) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.status = status;
        this.profileId = profileId;
        this.emailSent = emailSent;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Character getEmailSent() {
        return emailSent;
    }

    public void setEmailSent(Character emailSent) {
        this.emailSent = emailSent;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}






