package com.heroes.votingsystem.dto;

public class PollRequestDTO {
    private String question;
    // Diğer alanlar

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
