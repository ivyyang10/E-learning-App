package com.techelevator.dao;

import com.techelevator.model.Homework;

import java.util.List;

public interface HomeworkDao {
    Homework findHomeworkById(int HomeworkId);

    Homework submitHomework(int courseId, int studentId, String hwSubmission);

    Homework getHwById(int courseId, int studentId);

    void postGrade(Homework hw);

    List<Homework> getGradeByStudentId(int id);

    

}
