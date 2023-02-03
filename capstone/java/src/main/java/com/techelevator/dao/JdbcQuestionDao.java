package com.techelevator.dao;

import com.techelevator.model.Question;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

public class JdbcQuestionDao implements QuestionDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcQuestionDao (DataSource dataSource) { jdbcTemplate = new JdbcTemplate(dataSource) ; }


    @Override
    public boolean createQuestion(String questionText, int correctAnswer) {
        String sql = "INSERT INTO question (question_text, correct_answer)" +
                "VALUES (?, ?)";
        return jdbcTemplate.update(sql, questionText, correctAnswer) == 1;
    }

    @Override
    public List<Question> findAllQuestionsByQuizId(int quizId) {
        Question question = null;
        String sql = "SELECT * FROM question WHERE quizId = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, quizId);
        if(results.next()) {
            question = mapRowToQuestion(results);
        }

        return null;
    }

    private Question mapRowToQuestion(SqlRowSet result) {
        int questionId = result.getInt("question_id");
        String questionText = result.getString("question_text");
        int correctAnswer = result.getInt("correct_answer");
        return new Question(questionId, questionText, correctAnswer);
    }
}
