package com.coursemonitoringsystem.main;

import java.util.Scanner;

import com.coursemonitoringsystem.usecases.AdminUseCases;
import com.coursemonitoringsystem.usecases.FacultyUseCases;

public class Main {

	public static void users() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome To Course Monitor System");
		System.out.println("please select usertype : ");
		System.out.println("************************");
		System.out.println("1.Admin");
		System.out.println("2.Faculty");
		
		try {
			int type = sc.nextInt();
			if (type == 1) {
				Main.adminLogin();
			} else if(type == 2){
				Main.facultyLogin();
			}else {
				System.out.println("Please enter correct type : ");
				System.out.println();
				Main.users();
			}
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
/**************************************** Admin Functionalities Start Here *****************************************/		
	public static void adminLogin() {
		Scanner sc = new Scanner(System.in);

		AdminUseCases auc = new AdminUseCases();
 
		int flag = auc.aLogin();

		if (flag == 1) {
			Main.showAdminMenu();
			return;
		}

		if (flag == 0) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				Main.adminLogin();
			} else {
				Main.users();
			}

		}

	}
	
	public static void createCourse() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		
		int flag = auc.createCourse();

		if (flag == 1) {
			Main.showAdminMenu();
			return;
		}

		while (flag == 0) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.createCourse();
			} else {
				Main.showAdminMenu();
			}

		}

		if (flag == 1) {
			Main.showAdminMenu();
			return;
		}
	}
	
	public static void updateCourseName() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.updateCourseName();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.updateCourseName();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	public static void updateCourseFee() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.updateCourseFee();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.updateCourseFee();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	public static void updateCourseDesc() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.updateCourseDesc();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.updateCourseDesc();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	public static void removeCourseByCId() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.removeCourseByCid();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.removeCourseByCid();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	
	public static void courseDetailsByCId() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.viewCourseDetail();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.viewCourseDetail();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	public static void viewAllCourseDetails() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.viewAllCourseDetail();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.viewAllCourseDetail();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	public static void createBatch() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.createBatch();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.createBatch();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	public static void batchDetailsByBId() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.viewBatchDetail();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.viewBatchDetail();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	public static void viewAllBatchDetails() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.viewAllBatchDetails();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.viewAllBatchDetails();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	public static void updateNumberOfStudent() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.updateNumberOfStudentInBatch();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.updateNumberOfStudentInBatch();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
		
	public static void createFaculty() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.createFaculty();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.createFaculty();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	public static void updateFacultyName() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.updateFacultyName();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.updateFacultyName();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	public static void updateFacultyMobile() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.updateFacultyMobile();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.updateFacultyMobile();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	public static void updateFacultyadd() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.updateFacultyAddress();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.updateFacultyAddress();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	public static void removeFacultyByFId() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.removeFacultyByfid();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.removeFacultyByfid();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	
		
	public static void viewAllFacultyDetails() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.viewFacultyAllDetail();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.viewFacultyAllDetail();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	public static void AllocateFacultyToBatch(){
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.AllocateFacultyToBatch();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.AllocateFacultyToBatch();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	public static void createCoursePlan() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.createCoursePlan();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.createCoursePlan();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	public static void getCoursePlanDetailsByCpId() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.viewCoursePlanByBatch();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.viewCoursePlanByBatch();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
	public static void getDayWiseCoursePlanofBatch() {
		Scanner sc = new Scanner(System.in);
		AdminUseCases auc = new AdminUseCases();
		boolean flag =  auc.getDayWiseCoursePlanofBatch();
		if (flag) {
			Main.showAdminMenu();
			return;
		}
		while(flag == false) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				flag = auc.getDayWiseCoursePlanofBatch();
			} else {
				Main.showAdminMenu();
			}
		}
		if (flag) {
			Main.showAdminMenu();
			return;
		}
	}
	
/******************************************* Admin Functionality Done here ********************************************/
	
/******************************************* Faculty Functionalities Start Here *****************************************/
	public static void facultyLogin() {
		Scanner sc = new Scanner(System.in);

		FacultyUseCases fuc = new FacultyUseCases();
		int flag = fuc.facultyLogin();
 
		if (flag == 1) {
			Main.showFacultyMenu();
			return;
		}

		if (flag == 0) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				Main.facultyLogin();
			} else {
				Main.users();
			}

		}
	}

	public static void updatePass() {
		Scanner sc = new Scanner(System.in);

		FacultyUseCases fuc = new FacultyUseCases();
		int flag =  fuc.updatePassword();

		if (flag == 1) {
			Main.showFacultyMenu();
			return;
		}

		while(flag == 0) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				Main.updatePass();
			} else {
				Main.showFacultyMenu();
			}
		}
		if (flag == 1) {
			Main.showFacultyMenu();
			return;
		}
	}

	public static void changeStatusOfPlan() {
		Scanner sc = new Scanner(System.in);

		FacultyUseCases fuc = new FacultyUseCases();
		int flag =  fuc.changeStatusOfPlan();

		if (flag == 1) {
			Main.showFacultyMenu();
			return;
		}

		while(flag == 0) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				Main.changeStatusOfPlan();
			} else {
				Main.showFacultyMenu();
			}
		}
		if (flag == 1) {
			Main.showFacultyMenu();
			return;
		}
	}
	
	public static void fillDayWisePlanner() {
		Scanner sc = new Scanner(System.in);

		FacultyUseCases fuc = new FacultyUseCases();
		int flag =  fuc.fillDayWisePlanner();

		if (flag == 1) {
			Main.showFacultyMenu();
			return;
		}

		while(flag == 0) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				Main.fillDayWisePlanner();
			} else {
				Main.showFacultyMenu();
			}
		}
		if (flag == 1) {
			Main.showFacultyMenu();
			return;
		}
	}

	public static void viewCoursePlan() {
		Scanner sc = new Scanner(System.in);

		FacultyUseCases fuc = new FacultyUseCases();
		int flag =  fuc.viewCoursePlan();

		if (flag == 1) {
			Main.showFacultyMenu();
			return;
		}

		while(flag == 0) {
			System.out.println("Do you want to try again?");
			System.out.println("yes or no : ");
			String ans = sc.next();

			if (ans.equals("yes")) {
				Main.viewCoursePlan();
			} else {
				Main.showFacultyMenu();
			}
		}
		if (flag == 1) {
			Main.showFacultyMenu();
			return;
		}
	}
	
/******************************************* Faculty Functionalities Done Here *****************************************/	
	
/********************************************* Admin Menu Start Here ***************************************************/
	public static void showAdminMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("select any operation");
		System.out.println("==================================");
		System.out.println("1.Create Course");
		System.out.println("2.Update Course");
		System.out.println("3.Remove Course By Course Id");                            
		System.out.println("4.Get Course Detail By Course Id");
		System.out.println("5.Get All Course  Details");
		System.out.println("6.Create Batch");
		System.out.println("7.Update Number Of Student In Batch");
		System.out.println("8.Get Batch Detail By Batch Id");
		System.out.println("9.Get All Batch Details");
		System.out.println("10.Create Faculty");
		System.out.println("11.Remove Faculty By Faculty Id");                         
		System.out.println("12.Update Faculty");
		System.out.println("13.Allocate Faculty To Batch");
		System.out.println("14.Get All Faculty Details");
		System.out.println("15.Create CoursePlan");
		System.out.println("16.Get Day-Wise CoursePlan of Batch");
		System.out.println("17.Get CoursePlan Detail By CoursePlan Id");
		System.out.println("18.Logout");
		int type = sc.nextInt();   
		if (type == 1) {
			Main.createCourse();
		}
		else if(type == 2) {
			System.out.println("Please Select How You Want To Update A Course : ");
			System.out.println("1.Update Course By Name");
			System.out.println("2.Update Course By Fee");
			System.out.println("3.Update Course By Description");
			System.out.println("4.Back To Menu");
			int cin = sc.nextInt();
			if (cin == 1) {
				Main.updateCourseName();
			}else if(cin == 2) {
				Main.updateCourseFee();
			}else if (cin == 3) {
				Main.updateCourseDesc();
			}else {
				Main.showAdminMenu();
			}
		}
		else if (type == 3) {
			Main.removeCourseByCId();
		}
		else if (type == 4) {
			Main.courseDetailsByCId();
		}
		else if (type == 5) {
			Main.viewAllCourseDetails();
		}
		else if (type == 6) {
			Main.createBatch();
		}
		else if (type == 7) {
			Main.updateNumberOfStudent();
		}
		else if (type == 8) {
			Main.batchDetailsByBId();
		}
		else if (type == 9) {
			Main.viewAllBatchDetails();
		}
		else if (type == 10) {
			Main.createFaculty();	
		}
		else if (type == 11) {
			Main.removeFacultyByFId();
		}
		else if (type == 12) {
			System.out.println("Please Select How You Want To Update A Faculty : ");
			System.out.println("1.Update Course By Name");
			System.out.println("2.Update Course By Mobile");
			System.out.println("3.Update Course By Address");
			System.out.println("4.Back To Menu");
			int fin = sc.nextInt();
			if (fin == 1) {
				Main.updateFacultyName();
			}else if (fin == 2) {
				Main.updateFacultyMobile();
			}
			else if (fin == 3) {
				Main.updateFacultyadd();
			}else {
				Main.showAdminMenu();
			}
			
		}
		else if (type == 13) {
			Main.AllocateFacultyToBatch();
		}
		else if (type == 14) {
			Main.viewAllFacultyDetails();
		}else if (type == 15) {
			Main.createCoursePlan();
		}else if (type == 16) {
			Main.getDayWiseCoursePlanofBatch();
		}else if (type == 17) {
			Main.getCoursePlanDetailsByCpId();
		}
		else if (type == 18) {
			Main.users();
		}else {
			System.out.println("Please Enter valid input!");
			Main.showAdminMenu();
		}
	}

/********************************************* Admin Menu End Here ***************************************************/
	
/********************************************* Faculty Menu Start Here ***************************************************/
	public static void showFacultyMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Any Operation");
		System.out.println("====================");
		System.out.println("1.Update Password");
		System.out.println("2.Change Status Of Plan");
		System.out.println("3.Fill Day-Wise Planner");
		System.out.println("4.View Course Plan");
		System.out.println("5.Logout");
		int type = sc.nextInt();
		if (type == 1) {
			Main.updatePass();
		}
		else if (type == 2) {
			Main.changeStatusOfPlan();
		}
		else if (type == 3) {
			Main.fillDayWisePlanner();
		}
		else if (type == 4) {
			Main.viewCoursePlan();
		}else if (type == 5) {
			Main.users();
		}else {
			System.out.println("Please Enter valid input!");
			Main.showFacultyMenu();
		}
		
	}
/********************************************* Faculty Menu End Here ***************************************************/
	public static void main(String [] args) {
		Main.users();
	}

}
