package com.datingapp.auth.data.entity;


import com.datingapp.auth.data.common.EnumUserGender;
import com.datingapp.auth.data.common.EnumUserRole;
import com.datingapp.auth.data.common.EnumUserStatus;
import lombok.Data;
import lombok.ToString;


import java.io.Serializable;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Data
@ToString
public class AppUser extends BaseEntity implements Serializable {

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
}
