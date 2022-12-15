package com.coursemonitoringsystem.dao;

import java.util.List;

import com.coursemonitoringsystem.exception.AdminException;
import com.coursemonitoringsystem.exception.BatchException;
import com.coursemonitoringsystem.exception.CourseException;
import com.coursemonitoringsystem.exception.CoursePlanException;
import com.coursemonitoringsystem.exception.FacultyException;
import com.coursemonitoringsystem.model.Batch;
import com.coursemonitoringsystem.model.Course;
import com.coursemonitoringsystem.model.CoursePlan;
import com.coursemonitoringsystem.model.Faculty;

public interface AdminDao {
	
//                                   <--------- Admin Login start here ---->
/*======================================================================================================================*/	
	public String adminLogin(String username, String password) throws AdminException;
	
//	                                  <--------- All course start here ----->
/*======================================================================================================================*/	
	public String createCourse(Course course) throws CourseException;

	public String updateCourseFee(int courseId, int courseFee) throws CourseException;

	public String updateCourseDuration(int courseId, String courseDescription) throws CourseException;

	public String updateCourseName(int courseId, String courseName) throws CourseException;
	
	public Course getCourseDetail(int CourseId) throws CourseException;
	
	public List<Course> getAllCourseDetail() throws CourseException;
	
//                                      <--------- All batch start here ----->
/*======================================================================================================================*/

    public String createBatch(Batch batch) throws BatchException;
    
	public String updateNumberOfStudentInBatch(int studNum , int batchId) throws BatchException;
	
	public Batch getBatchDetail(int batchId) throws BatchException;
	
	public List<Batch> getAllBatchDetail() throws BatchException;
	
//                                      <--------- All Faculty start here ----->
/*======================================================================================================================*/

	public String AllocateFacultyToBatch(int facultyId, int batchId) throws BatchException, FacultyException;
	
	public String updateFacultyName(int facultyId , String facultyName) throws FacultyException;
	
	public String updateFacultyAddress(int facultyId , String facultyAddress) throws FacultyException;
	
	public String updateFacultyMobile(int facultyId , String facultyMobile) throws FacultyException;
	
	public String createFaculty(Faculty faculty) throws FacultyException;
	
	public List<Faculty> getFacultyAllDetail() throws FacultyException;
	
//                                       <--------- All Course Plan start here ----->
/*======================================================================================================================*/
 
    public String createCoursePlan(CoursePlan cp) throws CoursePlanException;

	public List<CoursePlan> getCoursePlanByBatch(int batchId) throws CoursePlanException;

	public CoursePlan getDayWiseCoursePlanofBatch(int batchId , int day) throws CoursePlanException;
	
}
