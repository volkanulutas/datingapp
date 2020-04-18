package com.datingapp.matching.data.entity;

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
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserPreference extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -5953961331027906732L;

    private int placeRange;

    private int minimumAge;

    private int maximumAge;

    private EnumUserGender gender;
}
