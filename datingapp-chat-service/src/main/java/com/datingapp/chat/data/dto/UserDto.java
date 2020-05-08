package com.datingapp.chat.data.dto;

import com.datingapp.chat.data.common.EnumUserGender;
import com.datingapp.chat.data.common.EnumUserStatus;
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
    private static final long serialVersionUID = -1530182518882098453L;

    private String id;

    private boolean isDeleted;

    private String username;

    private String name;

    private String surname;

    private long birthDate;

    private String birthPlace;

    private EnumUserStatus status;

    private EnumUserGender gender;
}
