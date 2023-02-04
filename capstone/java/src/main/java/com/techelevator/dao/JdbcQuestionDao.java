package com.techelevator.dao;

import com.techelevator.model.Question;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcQuestionDao implements QuestionDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcQuestionDao (DataSource dataSource) { jdbcTemplate = new JdbcTemplate(dataSource) ; }

    @Override
    public  Question getQuestion(int questionID){
        Question question = null;
        String sql = "SELECT * FROM question WHERE question_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,questionID);
        if(result.next()){
            question=mapRowToQuestion(result);
        }
        return question;

}
    @Override
    public Question createQuestion(Question newQuestion) {
        String sql = "INSERT INTO question (question_text, correct_answer, answer_1, answer_2, answer_3, answer_4, answer_5, answer_6) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING question_id;";

        Integer questionID = jdbcTemplate.queryForObject(sql, Integer.class, newQuestion.getQuestionText(),newQuestion.getCorrectAnswer(), newQuestion.getAnswer1(),
                newQuestion.getAnswer2(),newQuestion.getAnswer3(),newQuestion.getAnswer4(),newQuestion.getAnswer5(),newQuestion.getAnswer6());

        return getQuestion(questionID);

    }

    @Override
    public boolean updateQuizQuestionTable(int quizID, int questionID){
        String sql="INSERT INTO quiz_question(quiz_id, question_id) VALUES (?,?)";

       return jdbcTemplate.update(sql,quizID,questionID)==1;
    }

    @Override
    public List<Question> findAllQuestionsByQuizId(int quizId) {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM question as b " +
                "JOIN quiz_question AS d on b.question_id = d.question_id " +
                "JOIN quiz AS e on d.quiz_id = e.quiz_id WHERE e.quiz_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, quizId);
        while(results.next()) {
            Question question = mapRowToQuestion(results);
            questions.add(question);
        }

        return questions;
    }

    private Question mapRowToQuestion(SqlRowSet result) {
        int questionId = result.getInt("question_id");
        String questionText = result.getString("question_text");
        int correctAnswer = result.getInt("correct_answer");
        String answer1 = result.getString("answer_1");
        String answer2 = result.getString("answer_2");
        String answer3 = result.getString("answer_3");
        String answer4 = result.getString("answer_4");
        String answer5 = result.getString("answer_5");
        String answer6 = result.getString("answer_6");
        return new Question(questionId, questionText, correctAnswer, answer1, answer2, answer3,answer4,answer5,answer6);
    }
}
