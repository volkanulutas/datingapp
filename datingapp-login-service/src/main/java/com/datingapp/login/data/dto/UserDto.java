package com.datingapp.login.data.dto;

import com.datingapp.login.data.common.EnumUserGender;
import com.datingapp.login.data.common.EnumUserRole;
import com.datingapp.login.data.common.EnumUserStatus;
import com.datingapp.login.data.common.UserPreference;
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
public class UserDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = 231982723451329765L;

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

    private UserPreference userPreference;

    public UserDto(String username, String password, EnumUserRole userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }
}
