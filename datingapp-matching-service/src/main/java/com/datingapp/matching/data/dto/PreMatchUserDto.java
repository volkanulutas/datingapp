package com.datingapp.matching.data.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 30.03.2020
 *
 * @author volkanulutas
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PreMatchUserDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = 3758266682606136443L;

    private String id;

    private UserDto user;

    private List<UserDto> matchingList;
}
