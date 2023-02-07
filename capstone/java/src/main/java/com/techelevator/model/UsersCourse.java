package com.techelevator.model;

public class UsersCourse {
    private int userId;
    private int courseId;
    private boolean completed;
    private String name;

    public UsersCourse(int courseId, boolean completed, String name) {
        this.courseId = courseId;
        this.completed = completed;
        this.name = name;
    }

    public UsersCourse(int userId, int courseId, boolean completed) {
        this.userId = userId;
        this.courseId = courseId;
        this.completed = completed;
    }

    public UsersCourse() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UsersCourse{" +
                "userId=" + userId +
                ", courseId=" + courseId +
                ", completed=" + completed +
                '}';
    }
}
