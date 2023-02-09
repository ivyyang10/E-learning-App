package com.techelevator.dao;

import com.techelevator.model.Homework;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
    public Homework submitHomework(int courseId, int studentId, Homework hw) {
        String sql= "UPDATE homework SET hw_submission = ?, completed = ? " +
                "WHERE course_id = ? AND student_id = ?;";
        boolean isCompleted=true;

        jdbcTemplate.update(sql, hw.getHwSubmission(), isCompleted, courseId, studentId);

        return findHomeworkById(hw.getHomeworkId());
    }

    @Override
    public Homework getHwById(int courseId, int studentId) {
         Homework homework= null;
        String sql="SELECT * FROM homework WHERE course_id=? and student_id=?";

        SqlRowSet result= jdbcTemplate.queryForRowSet(sql,courseId,studentId);

        if(result.next()){
            homework =mapRowToHomework(result);
        }
        return homework;
    }

    @Override
    public void postGrade(Homework hw){

        String sql = "UPDATE homework SET grade = ? WHERE homework_id = ?";
        jdbcTemplate.update(sql, hw.getGrade(), hw.getHomeworkId());
    }

    @Override
    public List<Homework> checkHwByStudentId(int id) {
        List<Homework> homeworks = new ArrayList<>();
        String sql="SELECT * FROM homework WHERE student_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);
        while(results.next()){
            Homework homework=mapRowToHomework(results);
            homeworks.add(homework);
        }

        return homeworks;
    }

    @Override
    public List<Homework> checkHwByCourseId(int id) {
        List<Homework> homeworks = new ArrayList<>();
        String sql="SELECT DISTINCT name, h.course_id, completed, h.student_id, grade FROM homework AS h " +
                "JOIN users AS u on h.student_id = u.user_id " +
                "JOIN users_course AS uc ON u.user_id = uc.user_id " +
                "WHERE h.course_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);
        while(results.next()){
            Homework homework=mapRowToHomework2(results);
            homeworks.add(homework);
        }
        return homeworks;
    }

    private Homework mapRowToHomework(SqlRowSet result){
        Homework homework = new Homework();
        homework.setHomeworkId(result.getInt("homework_id"));
        homework.setCourseId(result.getInt("course_id"));
        homework.setStudentId(result.getInt("student_id"));
        homework.setHwSubmission(result.getString("hw_submission"));
        homework.setCompleted(result.getBoolean("completed"));
        homework.setGrade(result.getInt("grade"));

        return homework;
    }

    private Homework mapRowToHomework2(SqlRowSet result){
        Homework homework = new Homework();
        homework.setCourseId(result.getInt("course_id"));
        homework.setStudentId(result.getInt("student_id"));
        homework.setCompleted(result.getBoolean("completed"));
        homework.setName(result.getString("name"));
        homework.setGrade(result.getInt("grade"));

        return homework;
    }
}
