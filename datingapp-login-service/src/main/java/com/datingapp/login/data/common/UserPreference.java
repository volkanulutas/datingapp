package com.datingapp.login.data.common;

import com.datingapp.login.data.entity.BaseEntity;
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
@AllArgsConstructor
@NoArgsConstructor
public class UserPreference extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -6002181418554923253L;

    private int placeRange;

    private int minimumAge;

    private int maximumAge;

    private EnumUserGender gender;
}
