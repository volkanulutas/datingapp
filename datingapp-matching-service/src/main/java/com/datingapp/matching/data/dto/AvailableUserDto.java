package com.datingapp.matching.data.dto;


import com.datingapp.matching.data.common.EnumUserGender;
import com.datingapp.matching.data.common.EnumUserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
public class AvailableUserDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = -4777500450151947929L;

    public String id;

    private String username;

    private String name;

    private String surname;

    private long birthDate;

    private String birthPlace;

    private EnumUserStatus status;

    private EnumUserGender gender;

    private UserPreferenceDto userPreference;
}
