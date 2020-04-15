package com.datingapp.auth.data.dto;

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
public class LoginRequestDto implements Serializable {
    private static final long serialVersionUID = -103057131321626375L;

    private String username;

    private String password;
}
