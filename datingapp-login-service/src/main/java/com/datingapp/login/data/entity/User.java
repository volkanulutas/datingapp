package com.datingapp.login.data.entity;


import com.datingapp.login.data.common.EnumUserGender;
import com.datingapp.login.data.common.EnumUserRole;
import com.datingapp.login.data.common.EnumUserStatus;
import com.datingapp.login.data.common.UserPreference;
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
@ToString(exclude = "id")
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "User")
public class User extends BaseEntity implements Serializable {

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
}
