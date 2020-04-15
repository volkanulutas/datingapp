package com.datingapp.matching.data.entity;


import com.datingapp.matching.data.common.EnumUserGender;
import com.datingapp.matching.data.common.EnumUserRole;
import com.datingapp.matching.data.common.EnumUserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection = "AvailableUser")
public class AvailableUser extends BaseEntity implements Serializable {

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

    public AvailableUser(String username, String password, EnumUserRole userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }
}
