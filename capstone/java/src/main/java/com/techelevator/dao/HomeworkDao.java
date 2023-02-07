package com.techelevator.dao;

import com.techelevator.model.Homework;

public interface HomeworkDao {
    Homework findHomeworkById(int HomeworkId);

    Homework submitHomework(int courseId, int studentId, String hwSubmission);

}
