package com.coursemonitoringsystem.model;

public class Faculty {
	private int facultyId;
	private String facultyName;
	private String facultyEmail;
	private String facultyPassword;
	private String facultyAddress;
	
	public Faculty() {
		
	}

	public Faculty(int facultyId, String facultyName, String facultyEmail, String facultyPassword,
			String facultyAddress) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.facultyEmail = facultyEmail;
		this.facultyPassword = facultyPassword;
		this.facultyAddress = facultyAddress;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getFacultyEmail() {
		return facultyEmail;
	}

	public void setFacultyEmail(String facultyEmail) {
		this.facultyEmail = facultyEmail;
	}

	public String getFacultyPassword() {
		return facultyPassword;
	}

	public void setFacultyPassword(String facultyPassword) {
		this.facultyPassword = facultyPassword;
	}

	public String getFacultyAddress() {
		return facultyAddress;
	}

	public void setFacultyAddress(String facultyAddress) {
		this.facultyAddress = facultyAddress;
	}

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + ", facultyEmail=" + facultyEmail
				+ ", facultyPassword=" + facultyPassword + ", facultyAddress=" + facultyAddress + "]";
	}

	
	
}
