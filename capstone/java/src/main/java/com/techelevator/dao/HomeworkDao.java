package com.techelevator.dao;

import com.techelevator.model.Homework;

import java.util.List;

public interface HomeworkDao {
    Homework findHomeworkById(int HomeworkId);

    void submitHomework(int courseId, int studentId, Homework hw);

    Homework getHwById(int courseId, int studentId);

    void postGrade(Homework hw);

    List<Homework> checkHwByStudentId(int id);

    List<Homework> checkHwByCourseId(int id);

    

}
