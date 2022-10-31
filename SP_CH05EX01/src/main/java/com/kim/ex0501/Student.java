package com.kim.ex0501;

public class Student {
	private String name;
	private String age;
	private String gradeNum;
	private String classNum;
	
	public Student() {
		super();
	}

	public Student(String name, String age, String gradeNum, String classNum) {
		super();	// 4개의 파라메터를 가진 생성자
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classNum = classNum;
	}

	// getter, setter 메서드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGradeNum() {
		return gradeNum;
	}

	public void setGradeNum(String gradeNum) {
		this.gradeNum = gradeNum;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	
	
}
