package sdbms;

public class Student {
	String id;
	int age;
	String name;
	int marks;
	static int count=101;
	public Student(int age, String name, int marks) {
		this.id="JSP"+count;
		this.age = age;
		this.name = name;
		this.marks = marks;
		count++;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name + ", marks=" + marks + "]";
	}
	
	
	

}
