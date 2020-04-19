package com.datingapp.chat.data.dto;


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
public class MatchUserDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = 4479874208352915120L;

    private String id;

    private boolean isDeleted;

    private UserDto user;

    private List<UserDto> matchingList;
}
