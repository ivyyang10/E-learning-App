package com.techelevator.model;

import java.math.BigDecimal;

public class Course {
    private int courseId;
    private String courseName;
    private String description;
    private String difficulty;
    private BigDecimal cost;

    private int teacherId;

    public Course(int courseId, String courseName, String description, String difficulty, BigDecimal cost, int teacherId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.difficulty = difficulty;
        this.cost = cost;

        this.teacherId = teacherId;
    }

    public Course() {
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }


    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", description='" + description + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", cost=" + cost +
                ", teacherId=" + teacherId +
                '}';
    }
}
