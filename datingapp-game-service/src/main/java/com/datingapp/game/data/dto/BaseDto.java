package com.datingapp.game.data.dto;

import java.io.Serializable;

/**
 * Created on 27.03.2020
 *
 * @author onurcanyozgat
 */

public class BaseDto implements Serializable {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
