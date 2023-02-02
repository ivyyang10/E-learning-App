package com.techelevator.dao;

import com.techelevator.model.Course;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCourseDao  implements CourseDao{
    private JdbcTemplate jdbcTemplate;


    public JdbcCourseDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    public boolean createCourse(String courseName, String description, String difficulty, BigDecimal cost,
                                 int teacherId, String dailyInstruction, String links, String hwAssignments) {
        String insertCourseSql = "INSERT INTO course (course_name, description, difficulty, cost," +
                "teacher_id, daily_instruction, links, hw_assignment) " +
                "VALUES (?,?,?,?,?,?,?,?)";

        return jdbcTemplate.update(insertCourseSql, courseName, description, difficulty, cost, teacherId, dailyInstruction, links, hwAssignments) == 1;
    }

    @Override
    public List<Course> findAllCourses(int teacherId) {
        List<Course> courses = new ArrayList<>();
        String listSql = "SELECT * FROM course WHERE teacher_id = ?";
        SqlRowSet results=jdbcTemplate.queryForRowSet(listSql, teacherId);
        while(results.next()){
            Course course=mapRowToCourse(results);
            courses.add(course);
        }

        return courses;
    }

    @Override
    public Course findCourseById(int courseId){
        Course course = null;
        String sql = "Select * from course where course_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, courseId);
        if (results.next()) {
            course = mapRowToCourse(results);
        }
        return course;
    }

    private Course mapRowToCourse(SqlRowSet result){
        Course course = new Course();
        course.setCourseId(result.getInt("course_id"));
        course.setCourseName(result.getString("course_name"));
        course.setDescription(result.getString("description"));
        course.setDifficulty(result.getString("difficulty"));
        course.setCost(result.getBigDecimal("cost"));
        course.setTeacherId(result.getInt("teacher_id"));
        course.setDailyInstruction(result.getString("daily_instruction"));
        course.setLinks(result.getString("links"));
        course.setHwAssignment(result.getString("hw_assignment"));

        return course;
    }
}
