package com.datingapp.auth.data.dto;

import com.datingapp.auth.data.common.EnumUserGender;
import com.datingapp.auth.data.common.EnumUserRole;
import com.datingapp.auth.data.common.EnumUserStatus;
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
public class AppUserDto extends BaseDto implements Serializable {

    public String id;

    private String username;

    private String password;

    private String name;

    private String surname;

    private long birthDate;

    private String birthPlace;

    private byte[] userPicture;

    private EnumUserRole userRole;

    private Integer loginAttempt;

    private EnumUserStatus status;

    private EnumUserGender gender;

    public AppUserDto(String username, String password, EnumUserRole userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }
}
