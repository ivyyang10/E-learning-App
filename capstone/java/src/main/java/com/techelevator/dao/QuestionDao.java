package com.techelevator.dao;

import com.techelevator.model.Question;

import java.util.List;

public interface QuestionDao {

    Question getQuestion (int questionID);
   Question createQuestion (Question newQuestion);

    List<Question> findAllQuestionsByQuizId(int quizId);

    boolean updateQuizQuestionTable(int quizID, int questionID);
}
