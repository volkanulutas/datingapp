package com.datingapp.auth.data.dto;

import lombok.*;

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

    private String ipAddress;

    private String macAddress;
}
