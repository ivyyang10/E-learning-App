package com.techelevator.dao;

import com.techelevator.model.Course;
import com.techelevator.model.Homework;

import java.math.BigDecimal;
import java.util.List;

public interface CourseDao {
    boolean createCourse(String courseName, String description, String difficulty, BigDecimal cost,
                          int teacherId, String dailyInstruction, String links, String hwAssignments);

    List<Course> findAllCourses(int teacherId);

    Course findCourseById(int courseId);




}
