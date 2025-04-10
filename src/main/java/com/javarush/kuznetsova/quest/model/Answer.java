package com.javarush.kuznetsova.quest.model;

public class Answer {

    private Long id;
    private String text;
    private Long nextQuestionId;

    public Answer() {
    }

    public Answer(Long id, String text, Long nextQuestionId) {
        this.id = id;
        this.text = text;
        this.nextQuestionId = nextQuestionId;
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

    public Long getNextQuestionId() {
        return nextQuestionId;
    }

    public void setNextQuestionId(Long nextQuestionId) {
        this.nextQuestionId = nextQuestionId;
    }
}
