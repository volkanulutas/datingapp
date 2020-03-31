package com.datingapp.auth.data.dto.matchingservice;

import com.datingapp.auth.data.dto.BaseDto;
import com.datingapp.auth.data.common.EnumUserGender;
import com.datingapp.auth.data.common.EnumUserStatus;
import lombok.*;

import java.io.Serializable;

/**
 * Created on 30.03.2020
 *
 * @author volkanulutas
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AvailableMatchingUserDto extends BaseDto implements Serializable {

    public String id;

    private String username;

    private String name;

    private String surname;

    private long birthDate;

    private String birthPlace;

    private EnumUserStatus status;

    private EnumUserGender gender;
}
