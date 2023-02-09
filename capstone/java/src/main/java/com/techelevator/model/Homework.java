package com.techelevator.model;

public class Homework {
    private int homeworkId;
    private int courseId;
    private int studentId;
    private String hwSubmission;
    private boolean completed;
    private int grade;
    private String name;

    public Homework(int homeworkId, int courseId, int studentId, String hwSubmission, boolean completed, int grade, String name) {
        this.homeworkId = homeworkId;
        this.courseId = courseId;
        this.studentId = studentId;
        this.hwSubmission = hwSubmission;
        this.completed = completed;
        this.grade = grade;
        this.name = name;
    }


    public Homework() {
    }

    public int getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getHwSubmission() {
        return hwSubmission;
    }

    public void setHwSubmission(String hwSubmission) {
        this.hwSubmission = hwSubmission;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "homeworkId=" + homeworkId +
                ", courseId=" + courseId +
                ", studentId=" + studentId +
                ", hwSubmission='" + hwSubmission + '\'' +
                ", grade=" + grade +
                '}';
    }
}
