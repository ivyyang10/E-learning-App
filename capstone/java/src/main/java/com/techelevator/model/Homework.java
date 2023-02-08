package com.techelevator.model;

public class Homework {
    private int homeworkId;
    private int courseId;
    private int studentId;
    private String hwSubmission;
    private int grade;

    public Homework(int homeworkId, int courseId, int studentId, String hwSubmission, int grade) {
        this.homeworkId = homeworkId;
        this.courseId = courseId;
        this.studentId = studentId;
        this.hwSubmission = hwSubmission;
        this.grade = grade;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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
