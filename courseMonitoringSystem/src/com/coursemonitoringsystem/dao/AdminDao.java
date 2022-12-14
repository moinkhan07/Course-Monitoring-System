package com.coursemonitoringsystem.dao;

import java.util.List;

import com.coursemonitoringsystem.exception.AdminException;
import com.coursemonitoringsystem.exception.BatchException;
import com.coursemonitoringsystem.exception.CourseException;
import com.coursemonitoringsystem.model.Batch;
import com.coursemonitoringsystem.model.Course;

public interface AdminDao {
	
//  Admin Login start here ---->
	public String adminLogin(String username, String password) throws AdminException;
	
//	All course start here ----->
	public String createCourse(Course course) throws CourseException;

	public String updateCourseFee(int courseId, int courseFee) throws CourseException;

	public String updateCourseDuration(int courseId, String courseDuration) throws CourseException;

	public String updateCourseName(int courseId, String courseName) throws CourseException;
	
	public Course getCourseDetail(int CourseId) throws CourseException;
	
	public List<Course> getAllCourseDetail() throws CourseException;
	
//	All batch start here ------>
	
	public String createBatch(Batch batch) throws BatchException;
	
	
	

}
