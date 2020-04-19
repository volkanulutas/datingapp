package com.datingapp.user.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NetworkResponseDto implements Serializable {
    private static final long serialVersionUID = -5218117818565392033L;

    private String ipAddress;

    private String macAddress;
}
