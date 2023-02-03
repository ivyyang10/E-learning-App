package com.techelevator.model;

public class Answer {
    private int questionId;
    private int answerNumber;
    private String answerText;

    public Answer(int questionId, int answerNumber, String answerText) {
        this.questionId = questionId;
        this.answerNumber = answerNumber;
        this.answerText = answerText;
    }

    public Answer() {
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(int answerNumber) {
        this.answerNumber = answerNumber;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "questionId=" + questionId +
                ", answerNumber=" + answerNumber +
                ", answerText='" + answerText + '\'' +
                '}';
    }
}
