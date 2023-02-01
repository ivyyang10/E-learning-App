package com.techelevator.model;

public class Curricula {
    private int curriculumID;
    private String dailyInstruction;
    private String links;
    private String hwAssignment;
    private int courseID;

    public Curricula() {
    }

    public Curricula(int curriculumID, String dailyInstruction, String links, String hwAssignment, int courseID) {
        this.curriculumID = curriculumID;
        this.dailyInstruction = dailyInstruction;
        this.links = links;
        this.hwAssignment = hwAssignment;
        this.courseID = courseID;
    }

    public int getCurriculumID() {
        return curriculumID;
    }

    public void setCurriculumID(int curriculumID) {
        this.curriculumID = curriculumID;
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

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "Curricula{" +
                "curriculumID=" + curriculumID +
                ", dailyInstruction='" + dailyInstruction + '\'' +
                ", links='" + links + '\'' +
                ", hwAssignment='" + hwAssignment + '\'' +
                ", courseID=" + courseID +
                '}';
    }
}
