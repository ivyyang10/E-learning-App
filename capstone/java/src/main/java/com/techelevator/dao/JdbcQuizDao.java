package com.techelevator.dao;

import com.techelevator.model.Quiz;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcQuizDao implements QuizDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcQuizDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Quiz findQuizById(int quizId) {
        Quiz quiz = null;
        String sql = "SELECT * FROM quiz WHERE quiz_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, quizId);
        if (results.next()){
            quiz = mapToRowQuiz(results);
        }
        return quiz;
    }

    @Override
    public boolean createQuiz(String quizName, int courseId) {
        String sql = "INSERT INTO quiz (quiz_name, course_id)" +
                "VALUES (?, ?)";
        return jdbcTemplate.update(sql, quizName, courseId) == 1;
    }

    private Quiz mapToRowQuiz(SqlRowSet result){
        int quizId = result.getInt("quiz_id");
        String quizName = result.getString("quiz_name");
        int courseId = result.getInt("course_id");
        return new Quiz(quizId, quizName, courseId);
    }
}
