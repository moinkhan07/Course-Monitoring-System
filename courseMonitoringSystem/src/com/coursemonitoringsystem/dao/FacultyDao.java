package com.coursemonitoringsystem.dao;

import java.util.List;

import com.coursemonitoringsystem.exception.CoursePlanException;
import com.coursemonitoringsystem.exception.FacultyException;
import com.coursemonitoringsystem.model.CoursePlan;

public interface FacultyDao {
	
	public String facultyLogin(String username, String password) throws FacultyException;
	
	public String updatePassword(int facultyId, String password) throws FacultyException;

	public String changeStatusOfPlan(int batchId, int dayNumber, int facultyId)throws CoursePlanException;
	
	public String fillDayWisePlanner(int batchId, int dayNumber, int facultyId , String topic) throws CoursePlanException;
	
	public List<CoursePlan> getCoursePlan(int BatchId,int facultyId) throws CoursePlanException;

}
