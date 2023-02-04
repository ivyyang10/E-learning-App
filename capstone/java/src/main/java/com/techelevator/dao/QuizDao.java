package com.techelevator.dao;

import com.techelevator.model.Quiz;

public interface QuizDao {
    Quiz findQuizById(int quizId);

    Quiz createQuiz(Quiz newQuiz);
}
