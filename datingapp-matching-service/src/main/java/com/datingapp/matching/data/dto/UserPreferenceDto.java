package com.datingapp.matching.data.dto;

import com.datingapp.matching.data.common.EnumUserGender;
import lombok.*;

import java.io.Serializable;

/**
 * Created on 11.04.2020
 *
 * @author volkanulutas
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserPreferenceDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = 2041349911705616682L;

    private String id;

    private int placeRange;

    private int minimumAge;

    private int maximumAge;

    private EnumUserGender gender;
}
