package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import customsorting.SortStudentByAge;
import customsorting.SortStudentByMarks;
import customsorting.*;
import customeexception.StudentNotFoundException;
import customsorting.SortStudentByAge;

public class StudentManagementSystemImpl implements StudentManegmentSystem {
	Scanner ip=new Scanner(System.in);
	Map<String,Student> db=new LinkedHashMap<String,Student>();
	@Override
	public void addStudent() {
		System.out.println("Enter age");
		int age=ip.nextInt();
		System.out.println("enter name");
		String name=ip.next();
		System.out.println("enter marks");
		int marks=ip.nextInt();
		Student s1=new Student(age, name, marks);
		db.put(s1.getId(), s1);
		System.out.println("inserted successfully");
		System.out.println("student record inserted");
		System.out.println("student id is  "+s1.getId());

	}
	@Override
	public void displayStudent() {
		System.out.println("enter student id");
		String id=ip.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {//checking if id is present or not
			Student std=db.get(id);//getting the student object
			System.out.println("Id: "+std.getId());
			System.out.println("Name: "+std.getName());
			System.out.println("Age: "+std.getAge());
			System.out.println("Marks: "+std.getMarks());


		}
		else {
			String message="student with"+id+"not found";
			try {
				throw new StudentNotFoundException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllStudents() {
		if(db.size()!=0) {
			System.out.println("display all details");
			System.out.println("------------");
			Set<String> set=db.keySet();
			for(String key:set) {
				System.out.println(db.get(key));
			}
		}
		else {
			String message="student data base is empty nothing to display";
			try {
				throw new StudentNotFoundException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeStudent() {
		System.out.println("remove Student");
		String id=ip.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Student record found");
			db.remove(id);
			System.out.println("Student record deleated");
		}
		else {
			try {
				String message="student with"+id+"not found";
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}
	@Override
	public void removeAllStudent() {
		if(db.size()!=0) {
			System.out.println("students records available: "+db.size());
			db.clear();
			System.out.println("All records deleated Successfully");
			System.out.println("students record available"+db.size());
		}
		else {
			String message="student Database is empty nothing to deleate";
			try {
				throw new StudentNotFoundException(message);

			}
			catch(Exception e){
				System.out.println(message);

			}
		}

	}
	@Override
	public void updateStudent() {
		System.out.println("to update details enter id"
				+ "");
		String id=ip.next().toUpperCase();
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("enter choice\n1:for Update Age\n2:for Update Name\n3:for Update Age");
			int choice=ip.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Age");
				int age=ip.nextInt();
				std.setAge(age);//std.setAge(ip.nextInt);
				break;
			case 2:
				System.out.println("Enter Name");
				String name=ip.next();
				std.setName(name);//std.setName(ip.next());
				break;
			case 3:
				System.out.println("Enter Marks");
				int marks=ip.nextInt();
				std.setMarks(marks);//std.setMarks(ip.next());
				break;
			default :
				try {
					String message="Invalid choice kindly enter valid choice";
					throw new StudentNotFoundException(message);
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}

		}

	}
	@Override
	public void countStudents() {
		System.out.println("No of Student Records"+db.size());

	}
	@Override
	public void sortStudent() {
		//Map<String,Student> map=new LinkedHashMap<String,Student>();
		if(db.size()>=2) {
			Set<String> keys=db.keySet();
			List <Student>list=new ArrayList<Student>();
			for(String key:keys) {
				list.add(db.get(key));
			}
			System.out.println("enter choice\n1:sort by age\n2:sort by marks\n3:sort by name\n:4 sort by id");
			int choice=ip.nextInt();
			switch(choice) {
			case 1:
				System.out.println("sorting by age");
				Collections.sort(list,new SortStudentByAge());
				display(list);
				break;
			case 2:
				System.out.println("sorting by marks");
				Collections.sort(list,new SortStudentByMarks());
				display(list);
				break;
			case 3:
				System.out.println("sorting by name");
				Collections.sort(list,new SortStudentByName());
				display(list);
				break;
			case 4:
				System.out.println("sorting by name");
				Collections.sort(list,new SortStudentByName());
				display(list);
				break;
			default:
				try {
					String message="enter valid choice";
					throw new StudentNotFoundException(message);

				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				String message="No sufficient student records to sort";
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}
	@Override
	public void getStudentWithhighestMarks() {
		//Map<String,Student> map=new LinkedHashMap<String,Student>();
		if(db.size()>=2) {
			Set<String> keys=db.keySet();
			List <Student>list=new ArrayList<Student>();
			for(String key:keys) {
				list.add(db.get(key));
			}
			Collections.sort(list,new SortStudentByMarks());
			System.out.println(list.get(list.size()-1));
		}
		else {
			try {
				String message="No sufficient student records not found";
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public void getStudentWithLowestMarks() {
		//Map<String,Student> map=new LinkedHashMap<String,Student>();
		if(db.size()>=2) {
			Set<String> keys=db.keySet();
			List <Student>list=new ArrayList<Student>();
			for(String key:keys) {
				list.add(db.get(key));
			}
			Collections.sort(list,new SortStudentByMarks());
			System.out.println(list.get(0));
		}

		else {
			try {
				String message="No sufficient student records not found";
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}
	private static void display(List<Student> list) {
		for(Student s:list) {
			System.out.println(s);
		}
	}


}
