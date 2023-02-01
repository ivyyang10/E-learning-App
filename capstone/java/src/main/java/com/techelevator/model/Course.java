package com.techelevator.model;

import java.math.BigDecimal;

public class Course {
    private int courseId;
    private String courseName;
    private String description;
    private String difficulty;
    private BigDecimal cost;
    private int teacherId;
    private String dailyInstruction;
    private String links;
    private String hwAssignment;

    public Course(int courseId, String courseName, String description, String difficulty, BigDecimal cost, int teacherId, String dailyInstruction, String links, String hwAssignment) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.difficulty = difficulty;
        this.cost = cost;
        this.teacherId = teacherId;
        this.dailyInstruction = dailyInstruction;
        this.links = links;
        this.hwAssignment = hwAssignment;
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

    public String getDailyInstruction() {
        return dailyInstruction;
    }

    public void setDailyInstruction(String dailyInstruction) {
        this.dailyInstruction = dailyInstruction;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getHwAssignment() {
        return hwAssignment;
    }

    public void setHwAssignment(String hwAssignment) {
        this.hwAssignment = hwAssignment;
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
                ", dailyInstruction='" + dailyInstruction + '\'' +
                ", links='" + links + '\'' +
                ", hwAssignment='" + hwAssignment + '\'' +
                '}';
    }
}
