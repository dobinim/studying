package com.kim.ex0901;

public class Student {
	private String name;
	private int age;
	private int gradeNum;
	private int classNum;
	
	
	public Student() {
		super();
	}
	
	
	public Student(String name, int age, int gradeNum, int classNum) {
		super();
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classNum = classNum;
	}
	
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGradeNum() {
		return gradeNum;
	}
	public void setGradeNum(int gradeNum) {
		this.gradeNum = gradeNum;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	
	// getter, setter �� �߰� �޼���
	
	public void getStudentInfo() {
		System.out.println("�̸� : " + getName());
		System.out.println("���� : " + getAge());
		System.out.println("�г� : " + getGradeNum());
		System.out.println("�� : " + getClassNum());
	}
	
}
