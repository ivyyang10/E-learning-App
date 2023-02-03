package com.techelevator.controller;

import com.techelevator.dao.QuestionDao;
import com.techelevator.dao.QuizDao;
import com.techelevator.model.Question;
import com.techelevator.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class QuizController {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    @GetMapping("/viewquiz/{id}")
    public Quiz findQuizById(@PathVariable int id){
        Quiz quiz = quizDao.findQuizById(id);
        return quiz;
    }

    @GetMapping("/quiz/{id}")
    public List<Question> findAllQuestionsByQuizId(@PathVariable int id){
        return questionDao.findAllQuestionsByQuizId(id);
    }


}
