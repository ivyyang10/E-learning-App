package com.techelevator.dao;

import com.techelevator.model.Course;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;

@Component
public class JdbcCourseDao  implements CourseDao{
    private JdbcTemplate jdbcTemplate;


    public JdbcCourseDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public boolean createCourse(String courseName, String description, String difficulty, BigDecimal cost,
                                int curriculumId, int teacherId) {
        String insertCourseSql = "INSERT INTO course (course_name, description, difficulty, cost," +
                "curriculum_id, teacher_id VALUES (?,?,?,?,?,?)";

        return jdbcTemplate.update(insertCourseSql, courseName, description, difficulty, cost, curriculumId, teacherId) == 1;
    }

    @Override
    public List<Course> findAllCourses() {
        return null;
    }

    private Course mapRowToCourse(SqlRowSet result){
        Course course = new Course();
        course.setCourseId(result.getInt("course_id"));
        course.setCourseName(result.getString("course_name"));
        course.setDescription(result.getString("description"));
        course.setDifficulty(result.getString("difficulty"));
        course.setCost(result.getBigDecimal("cost"));
        course.setCurriculumId(result.getInt("curriculum_id"));
        course.setTeacherId(result.getInt("teacher_id"));

        return course;
    }
}
