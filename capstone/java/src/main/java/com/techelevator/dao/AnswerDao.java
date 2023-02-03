package com.techelevator.dao;

import com.techelevator.model.Answer;

import java.util.List;

public interface AnswerDao {

    boolean createAnswer (int answerNumber, String answerText);

    List<Answer> findAllAnswersByQuestionId (int questionId);

}
