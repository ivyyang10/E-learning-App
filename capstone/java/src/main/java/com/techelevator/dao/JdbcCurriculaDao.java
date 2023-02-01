package com.techelevator.dao;

import com.techelevator.model.Course;
import com.techelevator.model.Curricula;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcCurriculaDao implements CurriculaDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcCurriculaDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean createCurricula(String dailyInstruction, String links, String hwAssignment, int courseID) {
        String insertCurriculaSql = "INSERT INTO curricula (daily_instruction, links, hw_assignment,course_id)"+
                "VALUES (?,?,?,?)";

        return  jdbcTemplate.update(insertCurriculaSql, dailyInstruction, links, hwAssignment,courseID) == 1;
    }


    private Curricula mapRowToCourse(SqlRowSet result){
       Curricula curricula = new Curricula();
     curricula.setCurriculumID(result.getInt("curriculum_id"));
     curricula.setDailyInstruction(result.getString("daily_instruction"));
     curricula.setLinks(result.getString("links"));
     curricula.setHwAssignment(result.getString("hw_assignment"));
     curricula.setCourseID(result.getInt("course_id"));


        return curricula;
    }


}
