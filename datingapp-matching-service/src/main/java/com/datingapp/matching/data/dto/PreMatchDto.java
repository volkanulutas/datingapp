package com.datingapp.matching.data.dto;


import com.datingapp.matching.data.entity.User;
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
public class PreMatchDto extends BaseDto implements Serializable {

    private User user;

    private List<User> matchingList;
}
