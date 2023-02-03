package com.techelevator.dao;

import com.techelevator.model.Answer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcAnswerDao implements AnswerDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcAnswerDao(DataSource dataSource) { jdbcTemplate = new JdbcTemplate(dataSource); }


    @Override
    public boolean createAnswer(int answerNumber, String answerText) {
        String sql = "INSERT INTO answer (answer_number, answer_text)" +
                "VALUES (?, ?)";
        return jdbcTemplate.update(sql, answerNumber, answerText) == 1;
    }

    @Override
    public List<Answer> findAllAnswersByQuestionId(int questionId) {
        List<Answer> answers = new ArrayList<>();
        String sql = "SELECT * FROM answer WHERE question_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, questionId);
        while(results.next()) {
            Answer answer = mapToRowAnswer(results);
            answers.add(answer);
        }
        return answers;
    }

    private Answer mapToRowAnswer (SqlRowSet result) {
        int answerId = result.getInt("answer_id");
        int answerNumber = result.getInt("answer_number");
        String answerText = result.getString("answer_text");
        return new Answer(answerId, answerNumber, answerText);
    }
}
