package com.techelevator.dao;

import com.techelevator.model.UsersCourse;

import java.util.List;

public interface UsersCourseDao {

    List<UsersCourse> checkHwByStudentId(int id);

    List<UsersCourse> checkHwByCourseId(int id);
}
