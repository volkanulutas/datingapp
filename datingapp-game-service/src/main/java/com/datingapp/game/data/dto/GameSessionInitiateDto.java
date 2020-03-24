package com.datingapp.game.data.dto;

import com.datingapp.game.data.EnumGameType;

/**
 * Created on 24.03.2020
 *
 * @author onurcanyozgat
 */

public class GameSessionInitiateDto {

    private EnumGameType gameType;
    private long firstUserId;
    private long secondUserId;

    public EnumGameType getGameType() {
        return gameType;
    }

    public void setGameType(EnumGameType gameType) {
        this.gameType = gameType;
    }

    public long getFirstUserId() {
        return firstUserId;
    }

    public void setFirstUserId(long firstUserId) {
        this.firstUserId = firstUserId;
    }

    public long getSecondUserId() {
        return secondUserId;
    }

    public void setSecondUserId(long secondUserId) {
        this.secondUserId = secondUserId;
    }
}
