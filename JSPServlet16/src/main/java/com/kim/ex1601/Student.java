package com.kim.ex1601;

// bean Ŭ������ ��� ������ ���� getter, setter �޼��带 ���� Ŭ����
// DTO Ŭ����, �Ǵ� VO (Value Object) Ŭ������� ��.
public class Student {
	
	// ������� (�Ӽ�)
	private String name;
	private int age;
	private int grade;
	private int StudentNum;
	
	// �⺻�� ������ �� �� �κ��� �ش� ���� ��Ŭ�� > source > generate constructors from Superclass ������ �ͱ� �� �ִ� 
	public Student() {
		super();
		
	}

	// ��� ��� ������ �ʱ�ȭ�ϴ� ������ �� �� �κ��� ��Ŭ�� > source > generate constructors using fields ������ �ͱ� �� ����
	public Student(String name, int age, int grade, int studentNum) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
		StudentNum = studentNum;
	}

	// getter, setter �޼���� �� �� �κ��� ��Ŭ�� > source > generate getters and setters�� ���� �ͱ� �� ����
	public String getName() {
		return name;
	}

	public void setName(String name) {	// setter �޼���� ���� �ִ� ���̹Ƿ� ���� ��ȯ �ʿ� X 
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getStudentNum() {
		return StudentNum;
	}

	public void setStudentNum(int studentNum) {
		StudentNum = studentNum;
	}
	
}