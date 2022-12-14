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
import com.coursemonitoringsystem.exception.CoursePlanException;
import com.coursemonitoringsystem.exception.FacultyException;
import com.coursemonitoringsystem.model.Batch;
import com.coursemonitoringsystem.model.Course;
import com.coursemonitoringsystem.model.CoursePlan;
import com.coursemonitoringsystem.model.Faculty;
import com.coursemonitoringsystem.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

//                                  <--------- Admin Login Start Here ----->
/*======================================================================================================================*/
	@Override
	public String adminLogin(String username, String password) throws AdminException {
		String msg = "Invalid username & password";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from admin where username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				msg = "Welcome Back " + username;
			} else {
				throw new AdminException("Invalid username & password");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}

		return msg;
	}

//                                   <--------- All Course Start Here ----->
/*======================================================================================================================*/
	@Override
	public String createCourse(Course course) throws CourseException {
		String msg = "Course not created...";

		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into course values(?,?,?,?)");

			ps.setInt(1, course.getCourseId());
			ps.setString(2, course.getCourseName());
			ps.setInt(3, course.getCourseFee());
			ps.setString(4, course.getCourseDescription());

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

		try (Connection conn = DBUtil.provideConnection()) {
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
	public String updateCourseDuration(int courseId, String courseDescription) throws CourseException {
		String msg = "Course Duration Not Updated...";

		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("update course set coursedescription = ? where courseid = ?");
			ps.setString(1, courseDescription);
			ps.setInt(2, courseId);

			int x = ps.executeUpdate();

			if (x > 0) {
				msg = "Course Description Updated Successfully...";
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

		try (Connection conn = DBUtil.provideConnection()) {

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

		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from course where courseid = ?");
			ps.setInt(1, CourseId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				course = new Course(rs.getInt("courseId"), rs.getString("coursename"), rs.getInt("coursefee"),
						rs.getString("coursedescription"));
			} else {
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

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from course;");
			ResultSet rs = ps.executeQuery();
			boolean f = false;
			while (rs.next()) {
				f = true;
				Course c1 = new Course();
				c1.setCourseId(rs.getInt("courseId"));
				c1.setCourseName(rs.getString("coursename"));
				c1.setCourseFee(rs.getInt("coursefee"));
				c1.setCourseDuration(rs.getString("coursedescription"));
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

//                                      <--------- All Batch Start Here ----->
/*======================================================================================================================*/
	
	@Override
	public String createBatch(Batch batch) throws BatchException {
		String msg = "Batch not created...";

		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into batch values(?,?,?,?,?)");

			ps.setInt(1, batch.getBatchId());
			ps.setInt(2, batch.getCourseId());
			ps.setInt(3, batch.getNumberOfStudent());
			ps.setString(4, batch.getStartDate());
			ps.setString(5, batch.getDuration());

			int x = ps.executeUpdate();

			if (x > 0) {
				msg = "Batch created successfuly...";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}

		return msg;
	}

	@Override
	public Batch getBatchDetail(int batchId) throws BatchException {
		Batch batch = null;

		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from batch where batchid = ?");
			ps.setInt(1, batchId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				batch = new Batch(rs.getInt("batchid"),rs.getInt("courseId"),rs.getInt("facultyId"),rs.getInt("studentnumber"),rs.getString("startdate"),rs.getString("duration"));
			} else {
				throw new BatchException("No batch available with this ID :- " + batchId);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}

		return batch;
	}

	@Override
	public List<Batch> getAllBatchDetail() throws BatchException {
		List<Batch> listbatch = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from batch");
			ResultSet rs = ps.executeQuery();
			boolean f = false;
			while (rs.next()) {
				f = true;
				Batch b1 = new Batch();
				b1.setBatchId(rs.getInt("batchid"));
				b1.setCourseId(rs.getInt("courseId"));
				b1.setFacultyId(rs.getInt("facultyId"));
				b1.setNumberOfStudent(rs.getInt("studentnumber"));
				b1.setStartDate(rs.getString("startdate"));
				b1.setDuration(rs.getString("duration"));
				listbatch.add(b1);
				
			}
			if (f == false) {
				throw new BatchException("Batch Not Available In The Database...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}

		return listbatch;
	}

	@Override
	public String updateNumberOfStudentInBatch(int studNum, int batchId) throws BatchException {
		
		String msg = "Number of student not updated!";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("update batch set studentNumber = ? where batchid = ?");
			ps.setInt(1, studNum);
			ps.setInt(2, batchId);
			int x = ps.executeUpdate();
			if (x > 0) {
				msg = "Number of student in batchid " + batchId + " is Updated";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		return msg;
	}

	
//                                      <--------- All Faculty Start Here ----->
/*======================================================================================================================*/
	
	@Override
	public String AllocateFacultyToBatch(int facultyId, int batchId) throws BatchException, FacultyException {
		String msg = "Allocating to batchId is failed!";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("update batch set facultyid = ? where batchid = ?");
			ps.setInt(1, facultyId);
			ps.setInt(2, batchId);
			int x = ps.executeUpdate();
			if (x > 0) {
				msg = "Allocation of faculty to batch is successful...";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String updateFacultyName(int facultyId, String facultyName) throws FacultyException {
		String msg = "Updating faculty name failed!";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("update faculty set facultyname = ? where facultyid = ?");
			ps.setString(1, facultyName);
			ps.setInt(2, facultyId);
			int x = ps.executeUpdate();
			if (x > 0) {
				msg = "Faculty name updated successfully!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String updateFacultyAddress(int facultyId, String facultyAddress) throws FacultyException {
        String msg = "Updating faculty address failed!";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("update faculty set facultyaddress = ? where facultyid = ?");
			ps.setString(1, facultyAddress);
			ps.setInt(2, facultyId);
			int x = ps.executeUpdate();
			if (x > 0) {
				msg = "Faculty address updated successfully!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		return msg; 
	}

	@Override
	public String updateFacultyMobile(int facultyId, String facultyMobile) throws FacultyException {
		 String msg = "Updating faculty Mobile Number failed!";
			
			try (Connection conn = DBUtil.provideConnection()){
				PreparedStatement ps = conn.prepareStatement("update faculty set facultymobile = ? where facultyid = ?");
				ps.setString(1, facultyMobile);
				ps.setInt(2, facultyId);
				int x = ps.executeUpdate();
				if (x > 0) {
					msg = "Faculty Mobile Number updated successfully!";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new FacultyException(e.getMessage());
			}
			
			return msg; 
	}

	@Override
	public String createFaculty(Faculty faculty) throws FacultyException {
		String msg = "Faculty not created...";

		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into faculty values(?,?,?,?,?,?)");
			ps.setString(1, faculty.getFacultyName());
			ps.setString(2, faculty.getFacultyAddress());
			ps.setString(3, faculty.getFacultyMobile());
			ps.setString(4, faculty.getFacultyEmail());
			ps.setString(5, faculty.getFacultyUsername());
			ps.setString(6, faculty.getFacultyPassword());
			
			int x = ps.executeUpdate();

			if (x > 0) {
				msg = "Faculty created successfuly...";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}

		return msg;
	}

	@Override
	public List<Faculty> getFacultyAllDetail() throws FacultyException {
		List<Faculty> lFaculties = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from faculty");
			ResultSet rs = ps.executeQuery();
			boolean f = false;
			while(rs.next()) {
				f = true;
				Faculty faculty = new Faculty();
				faculty.setFacultyId(rs.getInt("facultyid"));
				faculty.setFacultyName(rs.getString("facultyname"));
				faculty.setFacultyAddress(rs.getString("facultyaddress"));
				faculty.setFacultyMobile(rs.getString("facultymobile"));
				faculty.setFacultyEmail(rs.getString("facultyemail"));
				faculty.setFacultyUsername(rs.getString("facultyusername"));
				faculty.setFacultyPassword(rs.getString("facultypassword"));
				lFaculties.add(faculty);
			}

			if (f == false) {
				throw new FacultyException("No faculty available in the database!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		return lFaculties;
	}

//                                       <---------All Course Plan Start Here ----->
/*======================================================================================================================*/

	
}



