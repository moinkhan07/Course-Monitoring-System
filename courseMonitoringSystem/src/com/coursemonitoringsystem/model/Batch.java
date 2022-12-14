package com.coursemonitoringsystem.model;

public class Batch {
	
	private int batchId;
	private int CourseId;
	private int facultyId;
	private int numberOfStudent;
	private String startDate;
	private String duration;
	
	public Batch() {
		// TODO Auto-generated constructor stub
	}

	public Batch(int batchId, int courseId, int facultyId, int numberOfStudent, String startDate, String duration) {
		super();
		this.batchId = batchId;
		CourseId = courseId;
		this.facultyId = facultyId;
		this.numberOfStudent = numberOfStudent;
		this.startDate = startDate;
		this.duration = duration;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public int getNumberOfStudent() {
		return numberOfStudent;
	}

	public void setNumberOfStudent(int numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", CourseId=" + CourseId + ", facultyId=" + facultyId
				+ ", numberOfStudent=" + numberOfStudent + ", startDate=" + startDate + ", duration=" + duration + "]";
	}
	
	
	
	
}
