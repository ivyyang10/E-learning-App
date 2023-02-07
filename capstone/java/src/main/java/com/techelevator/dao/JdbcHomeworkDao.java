package com.techelevator.dao;

import com.techelevator.model.Homework;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcHomeworkDao implements HomeworkDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcHomeworkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Homework findHomeworkById(int homeworkId) {
        Homework homework =null;
        String sql ="SELECT * FROM homework WHERE homework_id=?";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql,homeworkId);
        if(results.next()){
            homework =mapRowToHomework(results);
        }

        return homework;
    }

    @Override
    public Homework submitHomework(int courseId, int studentId, String hwSubmission) {
        String sql1= "INSERT INTO homework (course_id, student_id, hw_submission)"+
                "VALUES (?,?,?) RETURNING homework_id";
        Integer homeworkId= jdbcTemplate.queryForObject(sql1,Integer.class,courseId,studentId,hwSubmission);

        String sql2= "UPDATE users_course SET completed = true WHERE user_id=? and course_id =?";
        jdbcTemplate.update(sql2,studentId,courseId);

        return findHomeworkById(homeworkId);
    }

    private Homework mapRowToHomework(SqlRowSet result){
        Homework homework = new Homework();
        homework.setHomeworkId(result.getInt("homework_id"));
        homework.setCourseId(result.getInt("course_id"));
        homework.setStudentId(result.getInt("student_id"));
        homework.setHwSubmission(result.getString("hw_submission"));

        return homework;
    }
}
