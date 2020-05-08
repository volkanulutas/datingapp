package com.datingapp.matching.data.dto;


import lombok.*;

import java.io.Serializable;
import java.util.List;

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
public class MatchUserDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = 2100040422552005150L;

    private String id;

    private boolean isDeleted;

    private UserDto user;

    private List<UserDto> matchingList;
}
