package com.datingapp.authdemo.dto.response;

import java.io.Serializable;
import java.util.List;

/**
 * Datingapp on 21.03.2020
 *
 * @author volkanulutas
 */
public class ResponseDTO implements Serializable {

    private List<AdminResponseDTO> adminResponseDTOS;

    private String message;

    public ResponseDTO() {
    }

    public ResponseDTO(List<AdminResponseDTO> adminResponseDTOS, String message) {
        this.adminResponseDTOS = adminResponseDTOS;
        this.message = message;
    }

    public List<AdminResponseDTO> getAdminResponseDTOS() {
        return adminResponseDTOS;
    }

    public void setAdminResponseDTOS(List<AdminResponseDTO> adminResponseDTOS) {
        this.adminResponseDTOS = adminResponseDTOS;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
