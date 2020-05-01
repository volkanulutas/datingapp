package com.datingapp.game.data.dto;

/**
 * Created on 02.04.2020
 *
 * @author onurcanyozgat
 */

public class QuestionAnsweredDto extends QuestionActionDto {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
