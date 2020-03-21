package com.datingapp.authdemo.exceptions;


import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Datingapp on 21.03.2020
 *
 * @author volkanulutas
 */
public class ErrorResponse implements Serializable {

    private String errorMsg;

    private String developerMsg;

    private HttpStatus responseStatus;

    private int responseCode;

    public ErrorResponse() {
    }

    public ErrorResponse(String errorMsg, String developerMsg,
                         HttpStatus responseStatus, int responseCode) {
        this.errorMsg = errorMsg;
        this.developerMsg = developerMsg;
        this.responseStatus = responseStatus;
        this.responseCode = responseCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getDeveloperMsg() {
        return developerMsg;
    }

    public void setDeveloperMsg(String developerMsg) {
        this.developerMsg = developerMsg;
    }

    public HttpStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(HttpStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}



