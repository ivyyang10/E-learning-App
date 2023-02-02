package com.techelevator.controller;

import com.techelevator.dao.CourseDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Course;
import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.plaf.IconUIResource;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@RestController
@CrossOrigin
public class CourseController {
    @Autowired
    CourseDao courseDao;
    @Autowired
    UserDao userDao;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/createcourse")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCourse(@Valid @RequestBody Course newCourse,Principal principal) {
        String loggedInUser = principal.getName();
        int teacherID = userDao.findIdByUsername(loggedInUser);

        courseDao.createCourse(newCourse.getCourseName(), newCourse.getDescription(), newCourse.getDifficulty(),
                newCourse.getCost(), teacherID, newCourse.getDailyInstruction(), newCourse.getLinks(), newCourse.getHwAssignment());
    }

    @GetMapping("/courses")
    public List<Course> listAllCourse(Principal principal){
        String user = principal.getName();
        int teacherId = userDao.findIdByUsername(user);
        return courseDao.findAllCourses(teacherId);
    }

    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable int id){
        Course course = courseDao.findCourseById(id);
        if(course == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course Not Found");
        } else {
            return course;
        }
    }
}
