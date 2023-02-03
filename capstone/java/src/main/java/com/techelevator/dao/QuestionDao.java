package com.techelevator.dao;

import com.techelevator.model.Question;

import java.util.List;

public interface QuestionDao {

    boolean createQuestion (String questionText, int correctAnswer, String answer1, String answer2, String answer3, String answer4, String answer5, String answer6);

    List<Question> findAllQuestionsByQuizId(int quizId);

}
