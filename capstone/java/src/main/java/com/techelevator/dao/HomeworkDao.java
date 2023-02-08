package com.techelevator.dao;

import com.techelevator.model.Homework;
import com.techelevator.model.UsersCourse;

import java.util.List;

public interface HomeworkDao {
    Homework findHomeworkById(int HomeworkId);

    Homework submitHomework(int courseId, int studentId, String hwSubmission);

    Homework getHwById(int courseId, int studentId);

    void postGrade(Homework hw);

    List<Homework> checkHwByStudentId(int id);

    List<Homework> checkHwByCourseId(int id);

    

}
