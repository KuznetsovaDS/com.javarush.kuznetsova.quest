package com.javarush.kuznetsova.quest.model;

import java.util.List;

public class Question {

    private Long id;
    private String text;
    private List<Answer> answers;
    private Boolean isWinning = false;

    public Question() {
    }

    public Question(Long id, String text, List<Answer> answers, Boolean isWinning) {
        this.id = id;
        this.text = text;
        this.answers = answers;
        this.isWinning = isWinning;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Boolean getIsWinning() {
        return isWinning;
    }

    public void setIsWinning(Boolean winning) {
        isWinning = winning;
    }
}
