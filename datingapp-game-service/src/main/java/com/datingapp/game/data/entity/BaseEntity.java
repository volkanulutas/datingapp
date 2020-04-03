package com.datingapp.game.data.entity;

import org.springframework.data.annotation.Id;

/**
 * Created on 27.03.2020
 *
 * @author onurcanyozgat
 */

public class BaseEntity {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
