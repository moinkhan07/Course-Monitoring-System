package com.coursemonitoringsystem.usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.coursemonitoringsystem.dao.AdminDao;
import com.coursemonitoringsystem.dao.AdminDaoImpl;
import com.coursemonitoringsystem.exception.AdminException;
import com.coursemonitoringsystem.exception.BatchException;
import com.coursemonitoringsystem.exception.CourseException;
import com.coursemonitoringsystem.model.Batch;
import com.coursemonitoringsystem.model.Course;

public class AdminUseCases {
	
	public int aLogin() {
		
		int flag = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username:- ");
		String user = sc.next();
		System.out.println("Enter Password:- ");
		String pass = sc.next();
		
		AdminDao aDao = new AdminDaoImpl();
		try {
			String result = aDao.adminLogin(user, pass);
			System.out.println(result);
			flag = 1;
		} catch (AdminException e) {
			e.printStackTrace();
			System.out.println("Do You Want To Try again?");
			flag = 0;
		}
	
		return flag;
		
	}

	public int createCourse() {
		
		int flag = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter course Id :- ");
		int id = sc.nextInt();

		System.out.println("Enter course Name :- ");
		String name = sc.nextLine();

		System.out.println("Enter course fee :- ");
		int fee = sc.nextInt();

		System.out.println("Enter course duration :- ");
		String duration = sc.nextLine();
		
		Course c = new Course();
	    c.setCourseId(id);
	    c.setCourseName(name);
	    c.setCourseFee(fee);
	    c.setCourseDuration(duration);
		
		AdminDao adao = new AdminDaoImpl();
	    try {
			String msg = adao.createCourse(c);
			System.out.println(msg);
			flag = 1;
		} catch (CourseException e) {
			e.printStackTrace();
			System.out.println("Do You Want To Try again?");
			flag = 0;
		}
		
		return flag;
		
	}
	
	public boolean updateCourseFee() {
		boolean flag = false;
		
		Scanner sc = new Scanner(System.in);
		
			System.out.println("Enter course Id :- ");
			int cId = sc.nextInt();

			System.out.println("Enter course fee :- ");
			int cFee = sc.nextInt();

		AdminDao ado = new AdminDaoImpl();

		try {
			String msg = ado.updateCourseFee(cId, cFee);

			System.out.println(msg);

			flag = true;

		} catch (CourseException e) {

			System.out.println(e.getMessage());
			System.out.println("Do You Want To Try again?");
			flag = false;

		}

		return flag;
	}

	public boolean updateCourseDuration() {
		boolean flag = false;

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter course Id :- ");
		int cId = sc.nextInt();

		System.out.println("Enter course Duration :- ");
		String duration = sc.nextLine();

		AdminDao ado = new AdminDaoImpl();

		try {
			String msg = ado.updateCourseDuration(cId, duration);

			System.out.println(msg);

			flag = true;

		} catch (CourseException e) {

			System.out.println(e.getMessage());
			System.out.println("Do You Want To Try again?");
			flag = false;

		}

		return flag;

	}

	public boolean updateCourseName (){
		
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter course Id :- ");
		int id = sc.nextInt();

		System.out.println("Enter course Name :- ");
		String cName = sc.nextLine();

		AdminDao ado = new AdminDaoImpl();

		try {
			String msg = ado.updateCourseName(id,cName);

			System.out.println(msg);

			flag = true;

		} catch (CourseException e) {

			System.out.println(e.getMessage());
			System.out.println("Do You Want To Try again?");
			flag = false;

		}

		return flag;
		
	}

	public boolean getCourseDetail() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter course Id :- ");
		int cId = sc.nextInt();

		AdminDao ado = new AdminDaoImpl();

		try {
			Course course = ado.getCourseDetail(cId);

			System.out.println(course);
			flag = true;

		} catch (CourseException e) {

			System.out.println(e.getMessage());
			System.out.println("Do You Want To Try again?");
			flag = false;

		}

		return flag;
	}

	public boolean getAllCourseDetail() {
		boolean flag = false;

		AdminDao ado = new AdminDaoImpl();

		try {
			List<Course> c1 = ado.getAllCourseDetail();

			for (Course c2 : c1) {
				System.out.println("Course Id :- " +c2.getCourseId());
				System.out.println("Course Name :- " + c2.getCourseName());
				System.out.println("Course Fee :- " + c2.getCourseFee());
				System.out.println("Course Duration :- " + c2.getCourseDuration());
				System.out.println("========================");
			}

			flag = true;

		} catch (CourseException e) {

			System.out.println(e.getMessage());
			System.out.println("Do You Want To Try again?");
			flag = false;

		}

		return flag;
	}
	
	public boolean createBatch() {
        
	    boolean flag = false;
		Scanner sc = new Scanner(System.in);
		
	    System.out.println("Enter batch Id :- ");
		int bId = sc.nextInt();

		System.out.println("Enter course Id :- ");
		int cId = sc.nextInt();

		System.out.println("Enter number of students :- ");
		int sNum = sc.nextInt();

		System.out.println("Enter batch start date :- ");
		String date = sc.nextLine();

		System.out.println("Enter duration in days :- ");
		String duration = sc.nextLine();
		
		Batch batch = new Batch();
		batch.setBatchId(bId);
		batch.setCourseId(cId);
		batch.setNumberOfStudent(sNum);
		batch.setStartDate(date);
		batch.setDuration(duration);
				
		AdminDao adao = new AdminDaoImpl();
		try {
			String msg = adao.createBatch(batch);
			System.out.println(msg);
			flag = true;
		} catch (BatchException e) {
			e.printStackTrace();
			System.out.println("Do you want to try again!");
			flag = false;
		}
		
		
		return flag;
	}
	

	
}
