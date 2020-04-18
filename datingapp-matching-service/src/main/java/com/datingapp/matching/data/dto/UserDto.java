package com.datingapp.matching.data.dto;

import com.datingapp.matching.data.common.EnumUserGender;
import com.datingapp.matching.data.common.EnumUserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseDto {
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
