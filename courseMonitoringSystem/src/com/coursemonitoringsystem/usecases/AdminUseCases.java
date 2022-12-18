package com.coursemonitoringsystem.usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.coursemonitoringsystem.dao.AdminDao;
import com.coursemonitoringsystem.dao.AdminDaoImpl;
import com.coursemonitoringsystem.exception.AdminException;
import com.coursemonitoringsystem.exception.BatchException;
import com.coursemonitoringsystem.exception.CourseException;
import com.coursemonitoringsystem.exception.CoursePlanException;
import com.coursemonitoringsystem.exception.FacultyException;
import com.coursemonitoringsystem.model.Batch;
import com.coursemonitoringsystem.model.Course;
import com.coursemonitoringsystem.model.CoursePlan;
import com.coursemonitoringsystem.model.Faculty;

public class AdminUseCases {
//                                        <--------- Admin Start Here ----->
/*======================================================================================================================*/
	public int aLogin() {
		
		int flag = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username:- ");
		String user = sc.next();
		System.out.println("Enter Password:- ");
		String pass = sc.next();
		
		AdminDao aDao = new AdminDaoImpl();
		System.out.println();
		try {
			String result = aDao.adminLogin(user, pass);
			System.err.println("===================================================================================================================================");
			System.out.println("|                                                          " +result + "                                                     |");
			System.out.println("===================================================================================================================================");
			System.err.println();
			flag = 1;
		} catch (AdminException e) {
			e.printStackTrace();
			flag = 0;
		}
		return flag;
		
	}

//                                       <--------- All Course Start Here ----->
/*======================================================================================================================*/
	public int createCourse() {
		
		int flag = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter course Id :- ");
		int id = sc.nextInt();

		System.out.println("Enter course Name :- ");
		String name = sc.next();

		System.out.println("Enter course fee :- ");
		int fee = sc.nextInt();

		System.out.println("Enter course description :- ");
		String desc = sc.next();
		
		Course c = new Course();
	    c.setCourseId(id);
	    c.setCourseName(name);
	    c.setCourseFee(fee);
	    c.setCourseDuration(desc);
		
		AdminDao adao = new AdminDaoImpl();
	    try {
			String msg = adao.createCourse(c);
			System.out.println(msg);
			flag = 1;
		} catch (CourseException e) {
			e.printStackTrace();
			flag = 0;
		}
		
		return flag;
		
	}
	
	public boolean removeCourseByCid() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course Id : ");
		int rem = sc.nextInt();
		
		AdminDao adao = new AdminDaoImpl();
		try {
			String msg = adao.removeCourseByCourseId(rem);
			System.out.println(msg);
			flag = true;
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
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
			e.printStackTrace();
			flag = false;

		}

		return flag;
	}

	public boolean updateCourseDesc() {
		boolean flag = false;

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter course Id :- ");
		int cId = sc.nextInt();

		System.out.println("Enter course Description :- ");
		String desc = sc.next();

		AdminDao ado = new AdminDaoImpl();

		try {
			String msg = ado.updateCourseDuration(cId, desc);

			System.out.println(msg);

			flag = true;

		} catch (CourseException e) {
			e.printStackTrace();
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
		String cName = sc.next();

		AdminDao ado = new AdminDaoImpl();

		try {
			String msg = ado.updateCourseName(id,cName);

			System.out.println(msg);

			flag = true;

		} catch (CourseException e) {
			e.printStackTrace();
			flag = false;

		}

		return flag;
		
	}

	public boolean viewCourseDetail() {
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
		    e.printStackTrace();
			flag = false;

		}

		return flag;
	}

	public boolean viewAllCourseDetail() {
		boolean flag = false;

		AdminDao ado = new AdminDaoImpl();

		try {
			List<Course> c1 = ado.getAllCourseDetail();
			System.out.println();
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("|"+ "CourseId" + "     |   " + "CourseName" + "     |    " + "CourseFee" + "    |    " + "CourseDescription" + " |");
			System.out.println("---------------------------------------------------------------------------");
			for (Course c2 : c1) {
				System.out.println("  " + c2.getCourseId() + "               " + c2.getCourseName() + "                 " + c2.getCourseFee() + "               " + c2.getCourseDescription());
			    System.out.println("---------------------------------------------------------------------------");
			}
			System.out.println();
			flag = true;

		} catch (CourseException e) {
			e.printStackTrace();
			flag = false;

		}

		return flag;
	}

//                                        <--------- All Batch  Start Here ----->
/*======================================================================================================================*/
	public boolean createBatch() {
		boolean flag = false;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter batch Id :- ");
		int bId = sc.nextInt();

		System.out.println("Enter course Id :- ");
		int cId = sc.nextInt();

		System.out.println("Enter number of students :- ");
		int studNum = sc.nextInt();

		System.out.println("Enter batch start date :- ");
		String date = sc.next();

		System.out.println("Enter duration :- ");
		String duration = sc.next();
		
		Batch batch = new Batch();
		batch.setBatchId(bId);
		batch.setCourseId(cId);
		batch.setNumberOfStudent(studNum);
		batch.setStartDate(date);
		batch.setDuration(duration);
		
		AdminDao adao = new AdminDaoImpl();
		try {
			String msg = adao.createBatch(batch);
			System.out.println(msg);
			flag = true;
		} catch (BatchException e) {
			e.printStackTrace();
			flag = false;
		}
		
		return flag;
	}
	
	public boolean viewBatchDetail() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter batch Id :- ");
		int bId = sc.nextInt();

		AdminDao ado = new AdminDaoImpl();

		try {
			Batch batch = ado.getBatchDetail(bId);
			System.out.println(batch);
			flag = true;

		} catch (BatchException e) {
			e.printStackTrace();
			flag = false;

		}

		return flag;
	}

	public boolean viewAllBatchDetails() {
		boolean flag = false;

		AdminDao ado = new AdminDaoImpl();
		
		try {
			List<Batch> batch = ado.getAllBatchDetail();
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------------------------------");
			System.out.println("|"+ "BatchId" + "     |   " + "CourseId" + "     |    " + "FacultyId" + "    |    " + "No_Of_Students" + "     |     " + "StartDate" +"      |     " + "Duration"+"     |     ");
			System.out.println("-----------------------------------------------------------------------------------------------------------------");
			batch.forEach(b ->{
			System.out.println("   " + b.getBatchId() + "            " + b.getCourseId() + "               " + b.getFacultyId() + "                   " + b.getNumberOfStudent() + "                  " + b.getStartDate() + "             " + b.getDuration());
			System.out.println("-----------------------------------------------------------------------------------------------------------------");
			});
			System.out.println();
			flag = true;
		} catch (BatchException e) {
			e.printStackTrace();
			flag = false;
		}

		return flag;
	}
	
	public boolean updateNumberOfStudentInBatch() {
		boolean flag = false;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter batch Id : ");
		int bId = sc.nextInt();
		System.out.println("Enter New Number Of Student : ");
		int num = sc.nextInt();
		
		AdminDao adao = new AdminDaoImpl();
		try {
			String msg = adao.updateNumberOfStudentInBatch(num, bId);
			System.out.println(msg);
			flag = true;
		} catch (BatchException e) {
			e.printStackTrace();
			flag = false;
		}
		
		return flag;
	}
	
//                                    <--------- All Faculty Start Here ----->
/*======================================================================================================================*/

	public boolean createFaculty() {
	     boolean flag = false;
	
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter faculty name :- ");
			String name = sc.next();

			System.out.println("Enter faculty address :- ");
			String address = sc.next();

			System.out.println("Enter faculty mobile :- ");
			String mobile = sc.next();

			System.out.println("Enter faculty email :- ");
			String email = sc.next();
			
			System.out.println("Enter faculty username :- ");
			String username = sc.next();
			
			String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			
			String password = "";
			int len = 8;
			
			while (len-- != 0) {
				int index = (int) (Math.random() * characters.length());
				password += characters.charAt(index);
			}
			
			Faculty faculty = new Faculty();
			faculty.setFacultyName(name);
			faculty.setFacultyAddress(address);
			faculty.setFacultyMobile(mobile);
			faculty.setFacultyEmail(email);
			faculty.setFacultyUsername(username);
			faculty.setFacultyPassword(password);
			
			AdminDao adao = new AdminDaoImpl();
			try {
				String msg = adao.createFaculty(faculty);
				System.out.println(msg);
				flag = true;
			} catch (FacultyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			}
		
	     return flag;
	}
	
	public boolean removeFacultyByfid() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Faculty Id : ");
		int rem = sc.nextInt();
		
		AdminDao adao = new AdminDaoImpl();
		try {
			String msg = adao.removeFacultyByFId(rem);
			System.out.println(msg);
			flag = true;
		} catch (FacultyException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	
	

	public boolean updateFacultyName() {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter faculty Id :- ");
		int id = sc.nextInt();

		System.out.println("Enter faculty Name :- ");
		String Name = sc.next();

		AdminDao ado = new AdminDaoImpl();

		try {
			String msg = ado.updateFacultyName(id,Name);

			System.out.println(msg);

			flag = true;

		} catch (FacultyException e) {
			e.printStackTrace();
			flag = false;

		}

		return flag;
	}
	
    public boolean updateFacultyAddress() {
    	boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Faculty Id :- ");
		int id = sc.nextInt();

		System.out.println("Enter Faculty Address :- ");
		String add = sc.next();

		AdminDao ado = new AdminDaoImpl();

		try {
			String msg = ado.updateFacultyAddress(id,add);

			System.out.println(msg);

			flag = true;

		} catch (FacultyException e) {
			e.printStackTrace();
			flag = false;

		}

		return flag;
	}
    
    public boolean updateFacultyMobile() {
    	boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter faculty Id :- ");
		int id = sc.nextInt();

		System.out.println("Enter faculty mobile :- ");
		String mobile = sc.next();

		AdminDao ado = new AdminDaoImpl();

		try {
			String msg = ado.updateFacultyMobile(id,mobile);

			System.out.println(msg);

			flag = true;

		} catch (FacultyException e) {
			e.printStackTrace();
			flag = false;

		}

		return flag;
	}

	public boolean viewFacultyAllDetail() {
        boolean flag = false;
		
        AdminDao adao = new AdminDaoImpl();
        try {
			List<Faculty> list = adao.getFacultyAllDetail();
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			System.out.println("| " + "FacultyId" +"   |    " + "FacultyName" +"   |    " + "FacultyAddress" + "    |    " + "FacultyMobile" +"    |     " + "FacultyEmail" + "    |     " + "FacultyUserName" + " |");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			list.forEach(f -> {
				System.out.println("   " + f.getFacultyId() + "                " + f.getFacultyName() + "                 " + f.getFacultyAddress() + "                " + f.getFacultyMobile() + "              " + f.getFacultyEmail() + "       " + f.getFacultyUsername());
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			});
			System.out.println();
			flag = true;
		} catch (FacultyException e) {
			e.printStackTrace();
			flag = false;
		}
        
		return flag;
	}
	
	public boolean AllocateFacultyToBatch() {
        boolean flag = false;
		
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Batch Id : ");
        int bId = sc.nextInt();
        
        System.out.println("Enter Faculty Id : ");
        int fId = sc.nextInt();
        
        AdminDao adao = new AdminDaoImpl();
        try {
			String msg = adao.AllocateFacultyToBatch(fId, bId);
			System.out.println(msg);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} 
		return flag;
	}

//                                       <--------- All Course Plan Start Here ----->
/*======================================================================================================================*/

	public boolean createCoursePlan() {
		boolean flag = false;
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter batch Id :- ");
		int Id = sc.nextInt();

		System.out.println("Enter day :- ");
		int day = sc.nextInt();

		System.out.println("Enter day topic :- ");
		String topic = sc.next();
		
		CoursePlan cp = new CoursePlan();
		cp.setBatchId(Id);
		cp.setDayNumber(day);
		cp.setTopic(topic);
		
		AdminDao adao = new AdminDaoImpl();
		
		try {
			String msg = adao.createCoursePlan(cp);
			System.out.println(msg);
			flag = true;
		} catch (CoursePlanException e) {
			e.printStackTrace();
			flag = false;
		}
		
		return flag;
	}

	public boolean viewCoursePlanByBatch() {
		boolean flag = false;
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter batch Id :- ");
		int bId = sc.nextInt();
		
		AdminDao adao = new AdminDaoImpl();
	    try {
			List<CoursePlan> list_cp  = adao.getCoursePlanByBatch(bId);
			list_cp.forEach(cp -> {
				System.out.println("Course Plan Id : " + cp.getPlanId());
				System.out.println("Batch Id : " + cp.getBatchId());
				System.out.println("No of Day : "+ cp.getDayNumber());
				System.out.println("Topic : " + cp.getTopic());
				System.out.println("Status : " + cp.getStatus());
				System.out.println("=============================");
			});
			flag = true;
		} catch (CoursePlanException e) {
			e.printStackTrace();
			flag = false;
		}
		
		
		return flag;
	}

	public boolean getDayWiseCoursePlanofBatch() {
		boolean flag = false;
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter batch Id :- ");
		int Id = sc.nextInt();

		System.out.println("Enter day :- ");
		int day = sc.nextInt();
		
		AdminDao adao = new AdminDaoImpl();
	    try {
			CoursePlan cp = adao.getDayWiseCoursePlanofBatch(Id, day);
			System.out.println(cp);
			flag = true;
		} catch (CoursePlanException e) {
			e.printStackTrace();
			flag = false;
		}
		
		
		
		return flag;
	}

}













