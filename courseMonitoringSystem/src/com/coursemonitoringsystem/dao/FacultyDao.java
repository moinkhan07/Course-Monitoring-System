package com.coursemonitoringsystem.dao;

import com.coursemonitoringsystem.exception.FacultyException;

public interface FacultyDao {
	
	public String facultyLogin(String username, String password) throws FacultyException;

}
