package com.coursemonitoringsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coursemonitoringsystem.exception.CoursePlanException;
import com.coursemonitoringsystem.exception.FacultyException;
import com.coursemonitoringsystem.model.CoursePlan;
import com.coursemonitoringsystem.utility.DBUtil;
import com.mysql.cj.exceptions.RSAException;

public class FacultyDaoImpl implements FacultyDao{

	@Override
	public String facultyLogin(String username, String password) throws FacultyException {
		String msg = "Invalid username or password...";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from faculty where facultyusername = ? and facultypassword = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				msg = "Welcome back " + rs.getString("facultyname") + " your Id is " + rs.getInt("facultyid");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String updatePassword(int facultyId, String password) throws FacultyException {
		String msg = "Password not update";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("update faculty set facultypassword = ? where facultyid = ?");
			ps.setString(1, password);
			ps.setInt(2, facultyId);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Password updated successfully...";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeStatusOfPlan(int batchId, int dayNumber, int facultyId) throws CoursePlanException {
        String msg = "Status not changed...";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from batch where batchId = ? AND facultyId = ?");

			ps.setInt(1, batchId);
			ps.setInt(2, facultyId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				PreparedStatement ps2 = conn.prepareStatement("update courseplan set status = 'completed' where dayNumber = ? and batchId = ?");
				ps2.setInt(1, dayNumber);
				ps2.setInt(2, batchId);

				int row = ps2.executeUpdate();

				if (row > 0) {
					msg = "status changed successful";
				}
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String fillDayWisePlanner(int batchId, int dayNumber, int facultyId, String topic) throws CoursePlanException {
		String msg = "Planner not updated...";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from batch where batchId = ? AND facultyId = ?");

			ps.setInt(1, batchId);
			ps.setInt(2, facultyId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				PreparedStatement ps2 = conn.prepareStatement("update courseplan set topic = ? where dayNumber = ? and batchId = ?");

				ps2.setString(1, topic);
				ps2.setInt(2, dayNumber);
				ps2.setInt(3, batchId);

				int row = ps2.executeUpdate();
				if (row > 0) {
					msg = "plan filled successful";
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}

		return msg;
	}

	@Override
	public List<CoursePlan> getCoursePlan(int BatchId, int facultyId) throws CoursePlanException {
		List<CoursePlan> list = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps1 = conn.prepareStatement("select * from batch where batchId = ? AND facultyId = ?");

			ps1.setInt(1, BatchId);
			ps1.setInt(2, facultyId);

			ResultSet rs2 = ps1.executeQuery();

			if (rs2.next()) {
				PreparedStatement ps = conn.prepareStatement("select * from courseplan where batchId = ? ");

				ps.setInt(1, BatchId);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					CoursePlan cp = new CoursePlan();
					cp.setPlanId(rs.getInt("planid"));
					cp.setBatchId(rs.getInt("batchid"));
					cp.setDayNumber(rs.getInt("dayNumber"));
					cp.setTopic(rs.getString("topic"));
					cp.setStatus(rs.getString("status"));
					list.add(cp);
					
				}

			} else {
				throw new CoursePlanException("Something went wrong!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());

		}

		return list;
	}

	

}
