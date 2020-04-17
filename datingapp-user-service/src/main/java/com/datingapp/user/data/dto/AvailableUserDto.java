package com.datingapp.user.data.dto;

import com.datingapp.user.data.common.EnumUserGender;
import com.datingapp.user.data.common.EnumUserStatus;
import lombok.*;

import java.io.Serializable;

/**
 * Created on 30.03.2020
 *
 * @author volkanulutas
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AvailableUserDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = 6667868544306190836L;

    private String id;

    private String username;

    private String name;

    private String surname;

    private long birthDate;

    private String birthPlace;

    private EnumUserStatus status;

    private EnumUserGender gender;

    private UserPreferenceDto userPreference;
}
