package com.techelevator.dao;

import com.techelevator.model.Quiz;

public interface QuizDao {
    Quiz findQuizById(int quizId);

    boolean createQuiz(String quizName, int courseId);
}
