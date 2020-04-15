package com.datingapp.auth.data.dto;

import com.datingapp.auth.data.common.EnumUserGender;
import lombok.*;

import java.io.Serializable;

/**
 * Created on 12.04.2020
 *
 * @author volkanulutas
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserPreferenceDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = 2081282360659628723L;

    private int placeRange;

    private int minimumAge;

    private int maximumAge;

    private EnumUserGender gender;
}
