package com.techelevator.controller;

import com.techelevator.dao.QuestionDao;
import com.techelevator.dao.QuizDao;
import com.techelevator.model.Question;
import com.techelevator.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
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


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/createquiz")
    @ResponseStatus(HttpStatus.CREATED)
    public Quiz createQuiz(@Valid @RequestBody Quiz newQuiz){
       return quizDao.createQuiz(newQuiz);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/createquiz/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Question createQuestion(@PathVariable int id, @Valid @RequestBody Question newQuestion){
        Question madeQuestion = questionDao.createQuestion(newQuestion);

        questionDao.updateQuizQuestionTable(id,madeQuestion.getQuestionId());

        return madeQuestion;
    }






}
