package com.datingapp.matching.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Getter
@Setter
@NoArgsConstructor
public class BaseEntity implements Serializable {
    @Id
    private String id;
}
