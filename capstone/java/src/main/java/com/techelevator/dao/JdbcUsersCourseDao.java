package com.techelevator.dao;

import com.techelevator.model.UsersCourse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUsersCourseDao implements UsersCourseDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcUsersCourseDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<UsersCourse> checkHwByStudentId(int id) {
        List<UsersCourse> usersCourses =new ArrayList<>();
        String sql ="SELECT * FROM users_course WHERE user_id = ?;";
        SqlRowSet results=jdbcTemplate.queryForRowSet(sql,id);
        while(results.next()){
            UsersCourse usersCourse = mapRowToStudent(results);
            usersCourses.add(usersCourse);
        }
        return usersCourses;
    }

    @Override
    public List<UsersCourse> checkHwByCourseId(int id) {
        List<UsersCourse> usersCourses =new ArrayList<>();
        String sql= "SELECT name, completed, course_id, u.user_id FROM users AS u " +
                "JOIN users_course AS uc ON u.user_id = uc.user_id " +
                "WHERE course_id = ?;";

        SqlRowSet results =jdbcTemplate.queryForRowSet(sql,id);
        while (results.next()){
            UsersCourse usersCourse =mapRowToTeacher(results);
            usersCourses.add(usersCourse);
        }

        return  usersCourses;
    }


    private UsersCourse mapRowToTeacher(SqlRowSet result){
        UsersCourse usersCourse = new UsersCourse();
        usersCourse.setCourseId(result.getInt("course_id"));
        usersCourse.setName(result.getString("name"));
        usersCourse.setCompleted(result.getBoolean("completed"));
        usersCourse.setUserId(result.getInt("user_id"));

        return usersCourse;
    }

    private UsersCourse mapRowToStudent(SqlRowSet result){
        UsersCourse usersCourse = new UsersCourse();
        usersCourse.setCourseId(result.getInt("course_id"));
        usersCourse.setUserId(result.getInt("user_id"));
        usersCourse.setCompleted(result.getBoolean("completed"));

        return usersCourse;
    }
}
