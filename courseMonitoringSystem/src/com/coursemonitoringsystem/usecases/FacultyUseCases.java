package com.coursemonitoringsystem.usecases;

import java.util.List;
import java.util.Scanner;

import com.coursemonitoringsystem.dao.FacultyDao;
import com.coursemonitoringsystem.dao.FacultyDaoImpl;
import com.coursemonitoringsystem.exception.CoursePlanException;
import com.coursemonitoringsystem.exception.FacultyException;
import com.coursemonitoringsystem.model.CoursePlan;

public class FacultyUseCases {
	
	public int facultyLogin() {
		int flag = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username : " );
		String username = sc.next();
		System.out.println("Enter password : ");
		String pass = sc.next();
		
		FacultyDao fdao = new FacultyDaoImpl();
		try {
			String msg = fdao.facultyLogin(username, pass);
			System.out.println(msg);
			flag = 1;
		} catch (FacultyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = 0;
		}
		
		return flag;
	}
	
	
	public int updatePassword() {
		int flag = 0;
		
		Scanner sc = new Scanner(System.in);
		System.err.println("Enter faculty id : ");
		int id = sc.nextInt();
		System.out.println("Enter new password :");
		String nPass = sc.next();
		
		FacultyDao fDao = new FacultyDaoImpl();
		try {
			String msg = fDao.updatePassword(id, nPass);
			System.out.println(msg);
			flag = 1;
		} catch (FacultyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = 0;
		}
		
		return flag;
	}
	
	
	public int changeStatusOfPlan() {
		int flag = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter batch id : ");
		int bid = sc.nextInt();
		
		System.out.println("Enter day number :");
		int dNum = sc.nextInt();
		
		System.out.println("Enter faculty id : ");
		int fId = sc.nextInt();
		
		FacultyDao fDao = new FacultyDaoImpl();
		try {
			String msg	= fDao.changeStatusOfPlan(bid, dNum, fId);
			System.out.println(msg);
			flag = 1;
		} catch (CoursePlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = 0;
		}	
		
		return flag;
	}
	

	public int fillDayWisePlanner() {
		int flag = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter batch id : ");
		int bId = sc.nextInt();
		System.out.println("Enter day number : ");
		int dNum = sc.nextInt();
		System.out.println("Enter faculty id : ");
		int fId = sc.nextInt();
		System.out.println("Enter topic : ");
		String topic = sc.next();
		
		FacultyDao fDao = new FacultyDaoImpl();
		try {
			String msg = fDao.fillDayWisePlanner(bId, dNum, fId, topic);
			System.out.println(msg);
			flag = 1;
		} catch (CoursePlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = 0;
		}
		
		
		return flag;
	}
	
	
	
	public int viewCoursePlan() {
		int flag = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter batch id : ");
		int bId = sc.nextInt();
		System.out.println("Enter faculty id : ");
		int fId = sc.nextInt();
		
		
		FacultyDao facultyDao = new FacultyDaoImpl();
		try {
			List<CoursePlan> list = facultyDao.getCoursePlan(bId, fId);
			list.forEach(l -> {
				System.out.println("Course Plan Id : " + l.getPlanId());
				System.out.println("Batch Id : " + l.getBatchId());
				System.out.println("Day Number : " + l.getDayNumber());
				System.out.println("Topic : " + l.getTopic());
				System.out.println("Status : " + l.getStatus());
				System.out.println("=============================");
			});
			flag = 1;
		} catch (CoursePlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = 0;
		}
		
		
		
		return flag;
	}

}






















