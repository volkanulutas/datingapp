package com.datingapp.matching.data.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection = "PreMatchUser")
public class PreMatchUser extends BaseEntity implements Serializable {

    private User user;

    private List<User> matchingList;
}
