package com.techelevator.dao;

import com.techelevator.model.Question;

import java.util.List;

public interface QuestionDao {

    boolean createQuestion (String questionText, int correctAnswer);

    List<Question> findAllQuestionsByQuizId(int quizId);

}
