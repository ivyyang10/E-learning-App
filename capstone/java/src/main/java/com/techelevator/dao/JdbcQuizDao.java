package com.techelevator.dao;

import com.techelevator.model.Quiz;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
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
    public Quiz createQuiz(Quiz newQuiz) {
        String sql = "INSERT INTO quiz (quiz_name, course_id)" +
                "VALUES (?, ?) RETURNING quiz_id";

        Integer quizID =jdbcTemplate.queryForObject(sql, Integer.class, newQuiz.getQuizName(),newQuiz.getCourseId());

        return findQuizById(quizID);

    }

    private Quiz mapToRowQuiz(SqlRowSet result){
        int quizId = result.getInt("quiz_id");
        String quizName = result.getString("quiz_name");
        int courseId = result.getInt("course_id");
        return new Quiz(quizId, quizName, courseId);
    }
}
