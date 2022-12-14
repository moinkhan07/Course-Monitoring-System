package com.coursemonitoringsystem.model;

public class Faculty {
	private int facultyId;
	private String facultyName;
	private String facultyAddress;
	private String facultyMobile;
	private String facultyEmail;
	private String facultyUsername;
	private String facultyPassword;
	
	public Faculty() {
		// TODO Auto-generated constructor stub
	}

	public Faculty(int facultyId, String facultyName, String facultyAddress, String facultyMobile, String facultyEmail,
			String facultyUsername, String facultyPassword) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.facultyAddress = facultyAddress;
		this.facultyMobile = facultyMobile;
		this.facultyEmail = facultyEmail;
		this.facultyUsername = facultyUsername;
		this.facultyPassword = facultyPassword;
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

	public String getFacultyAddress() {
		return facultyAddress;
	}

	public void setFacultyAddress(String facultyAddress) {
		this.facultyAddress = facultyAddress;
	}

	public String getFacultyMobile() {
		return facultyMobile;
	}

	public void setFacultyMobile(String facultyMobile) {
		this.facultyMobile = facultyMobile;
	}

	public String getFacultyEmail() {
		return facultyEmail;
	}

	public void setFacultyEmail(String facultyEmail) {
		this.facultyEmail = facultyEmail;
	}

	public String getFacultyUsername() {
		return facultyUsername;
	}

	public void setFacultyUsername(String facultyUsername) {
		this.facultyUsername = facultyUsername;
	}

	public String getFacultyPassword() {
		return facultyPassword;
	}

	public void setFacultyPassword(String facultyPassword) {
		this.facultyPassword = facultyPassword;
	}

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + ", facultyAddress=" + facultyAddress
				+ ", facultyMobile=" + facultyMobile + ", facultyEmail=" + facultyEmail + ", facultyUsername="
				+ facultyUsername + ", facultyPassword=" + facultyPassword + "]";
	}
	
	
	
}
