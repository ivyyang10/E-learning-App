package com.techelevator.model;

public class UsersCourse {
    private int userId;
    private int courseId;

    private String name;

    public UsersCourse(int courseId, String name) {
        this.courseId = courseId;

        this.name = name;
    }

    public UsersCourse(int userId, int courseId, boolean completed) {
        this.userId = userId;
        this.courseId = courseId;

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

                '}';
    }
}
