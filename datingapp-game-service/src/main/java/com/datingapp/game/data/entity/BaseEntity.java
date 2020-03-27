package com.datingapp.game.data.entity;

import javax.persistence.Column;

/**
 * Created on 27.03.2020
 *
 * @author onurcanyozgat
 */

public class BaseEntity {

    @Column(name = "ID")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
