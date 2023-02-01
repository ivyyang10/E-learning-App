package com.techelevator.controller;

import com.techelevator.dao.CourseDao;
import com.techelevator.dao.CurriculaDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Course;
import com.techelevator.model.Curricula;
import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class CourseController {
    @Autowired
    CourseDao courseDao;
    @Autowired
    UserDao userDao;
    @Autowired
    CurriculaDao curriculaDao;

    @PostMapping("/createcourse")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCourse(@Valid @RequestBody Course newCourse, @RequestBody Curricula newCurricula,Principal principal) {
        String loggedInUser = principal.getName();
        int teacherID=userDao.findIdByUsername(loggedInUser);

      courseDao.createCourse(newCourse.getCourseName(),newCourse.getDescription(),newCourse.getDifficulty(),
              newCourse.getCost(), teacherID) ;

      curriculaDao.createCurricula(newCurricula.getDailyInstruction(), newCurricula.getLinks(), newCurricula.getHwAssignment(), newCurricula.getCourseID());

    }



}
