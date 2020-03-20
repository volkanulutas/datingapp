package com.datingapp.login.responseDTO;


import java.io.Serializable;

/**
 * Datingapp on 20.03.2020
 *
 * @author volkanulutas
 */
public class NetworkResponseDTO implements Serializable {

    private String ipAddress;

    private String macAddress;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}
