package com.techelevator.dao;

import com.techelevator.model.Course;

import java.math.BigDecimal;
import java.util.List;

public interface CourseDao {
    boolean createCourse(String courseName, String description, String difficulty, BigDecimal cost,
                          int teacherId);

    List<Course> findAllCourses();
}
