package com.coursemonitoringsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.coursemonitoringsystem.exception.FacultyException;
import com.coursemonitoringsystem.utility.DBUtil;

public class FacultyDaoImpl implements FacultyDao{

	@Override
	public String facultyLogin(String username, String password) throws FacultyException {
		String msg = "Invalid Faculty username & password!";
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from faculty where facultyEmail = ? AND facultypassword = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		
		return msg;
	}

}
