package com.techelevator.model;

public class Quiz {
    private int quizId;
    private String quizName;
    private int courseId;

    public Quiz(int quizId, String quizName, int courseId) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.courseId = courseId;
    }

    public Quiz() {
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quizId=" + quizId +
                ", quizName='" + quizName + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
