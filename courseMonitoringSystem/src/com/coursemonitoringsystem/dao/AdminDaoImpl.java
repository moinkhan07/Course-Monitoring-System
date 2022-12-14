package com.coursemonitoringsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coursemonitoringsystem.exception.AdminException;
import com.coursemonitoringsystem.exception.BatchException;
import com.coursemonitoringsystem.exception.CourseException;
import com.coursemonitoringsystem.model.Batch;
import com.coursemonitoringsystem.model.Course;
import com.coursemonitoringsystem.utility.DBUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public String adminLogin(String username, String password) throws AdminException {
		String msg = "Invalid username & password";
		
		try(Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from admin where username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				msg = "Welcome Back " + username;
			}
			else {
				throw new AdminException("Invalid username & password");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		
		
		return msg;
	}


	//	Course start here ------->
	
	@Override
	public String createCourse(Course course) throws CourseException {
		String msg = "Course not created...";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into course values(?,?,?,?)");

			ps.setInt(1, course.getCourseId());
			ps.setString(2, course.getCourseName());
			ps.setInt(3, course.getCourseFee());
			ps.setString(4, course.getCourseDuration());

			int x = ps.executeUpdate();

			if (x > 0) {
				msg = "course created successfuly...";
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		
		return msg;
	}

	
	@Override
	public String updateCourseFee(int courseId, int courseFee) throws CourseException {
		String msg = "Course fee not updated...";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("update course set coursefee = ? where courseid = ?");
			ps.setInt(1, courseFee);
			ps.setInt(2, courseId);
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Course Fee Updated Successfully...";
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		
		return msg;	
	}

	
	@Override
	public String updateCourseDuration(int courseId, String courseDuration) throws CourseException {
		String msg = "Course Duration Not Updated...";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("update course set courseduration = ? where courseid = ?");
			ps.setString(1, courseDuration);
			ps.setInt(2, courseId);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Course Duration Updated Successfully...";
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		
		return msg;
	}

	
	@Override
	public String updateCourseName(int courseId, String courseName) throws CourseException {
		String msg = "Course Name Not Updated...";
		
        try (Connection conn = DBUtil.provideConnection()){
			
        	PreparedStatement ps = conn.prepareStatement("update course coursename = ? where courseid = ?");
        	ps.setString(1, courseName);
        	ps.setInt(2, courseId);
        	
        	int x = ps.executeUpdate();
        	if (x > 0) {
				msg = "Course Name updated Successfully...";
			}
        	
        	
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		} 
		
		
		return msg;
	}

	
	@Override
	public Course getCourseDetail(int CourseId) throws CourseException {
		Course course = null;
		
        try (Connection conn = DBUtil.provideConnection()){
        	PreparedStatement ps = conn.prepareStatement("select * from course where courseid = ?");
			ps.setInt(1, CourseId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				course = new Course(rs.getInt("courseId"),rs.getString("coursename"),rs.getInt("coursefee"),rs.getString("courseduration"));
			}else {
				throw new CourseException("No course available with this ID :- " + CourseId);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return course;
	}

	
	@Override
	public List<Course> getAllCourseDetail() throws CourseException {
		List<Course> listCourses = new ArrayList<>();
		

        try (Connection conn = DBUtil.provideConnection()){
        	
        	PreparedStatement ps = conn.prepareStatement("select * from course;");
        	ResultSet rs = ps.executeQuery();
        	boolean f = false;
        	while(rs.next()) {
        		f = true;
        		Course c1 = new Course();
        		c1.setCourseId(rs.getInt("courseId"));
        		c1.setCourseName(rs.getString("coursename"));
        		c1.setCourseFee(rs.getInt("coursefee"));
        		c1.setCourseDuration(rs.getString("courseduration"));
        		listCourses.add(c1);
        	}
        	if (f == false) {
				throw new CourseException("Course Not Available In The Database...");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return listCourses;
	}


	@Override
	public String createBatch(Batch batch) throws BatchException {
		String msg = "Batch not created...";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into batch values(?,?,?,?,?)");
			ps.setInt(1, batch.getBatchId());
			ps.setInt(2, batch.getCourseId());
			ps.setInt(3, batch.getNumberOfStudent());
			ps.setString(4, batch.getStartDate());
			ps.setString(5, batch.getDuration());
			int x = ps.executeUpdate();
			if (x > 0) {
				msg = "Batch created successfully...";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		return msg;
	}

	

}






