package sdbms;

import java.util.Scanner;

import customeexception.InvalidchoiceException;

public class Solution {
	public static void main(String[] args) {
		System.out.println("welcome to student database management ");
		System.out.println("-----------------");
		Scanner ip=new Scanner (System.in);
		//int choice=ip.nextInt();

		StudentManegmentSystem sms=new StudentManagementSystemImpl();
		while(true) {
			System.out.println("1: addStudent\n2:displayStudent\n3:displayAllstudents\n4:removeStudent\n5:removeAllStudents\n:6updateStudent:\n7countStudent\n:8sortstudent\n:9getStudentWithhighestMarks\n:10getStudentWithLowestMarks");
			int choice=ip.nextInt();
			switch(choice) {
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudents();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudent();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudents();
				break;
			case 8:
				sms.sortStudent();
				break;
			case 9:
				sms.getStudentWithhighestMarks();
				break;
			case 10:
				sms. getStudentWithLowestMarks();
				break;
			case 11:
				System.out.println("thank you");
				System.exit(0);
			default:
				try {
					throw new InvalidchoiceException("invalid choice ");

				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}

			}
			System.out.println("----------------");




		}



	}


}
