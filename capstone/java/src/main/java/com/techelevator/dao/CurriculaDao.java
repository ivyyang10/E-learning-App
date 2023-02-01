package com.techelevator.dao;

import java.math.BigDecimal;

public interface CurriculaDao {
    boolean createCurricula(String dailyInstruction,String links,String hwAssignment,int courseID);
}
