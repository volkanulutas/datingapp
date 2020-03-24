package com.datingapp.game.data.entity;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

public class ParticipantEntity {

    private long id;
    private long userId;
    private String nickname;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
