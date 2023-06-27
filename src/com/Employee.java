package com;

public class Employee {
	String id;
	String name;
	static int count=101;
	public Employee(String name) {
		this.id = "jsp"+count;
		this.name = name;
		count++;
	}
	public static void main(String[] args) {
		Employee e1=new Employee("shiva");
		System.out.println(e1.id+" "+e1.name);
		Employee e2=new Employee("sheshu");
		System.out.println(e2.id+" "+e2.name);
		

		
	}
	

}
