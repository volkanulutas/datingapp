package com.datingapp.game.data.entity;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

public class FastQuestionEntity extends BaseEntity {

    private long gameSessionId;
    private String content;

    public long getGameSessionId() {
        return gameSessionId;
    }

    public void setGameSessionId(long gameSessionId) {
        this.gameSessionId = gameSessionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
