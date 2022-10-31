package com.kim.ex1601;

// bean 클래스로 멤버 변수에 대한 getter, setter 메서드를 가진 클래스
// DTO 클래스, 또는 VO (Value Object) 클래스라고도 함.
public class Student {
	
	// 멤버변수 (속성)
	private String name;
	private int age;
	private int grade;
	private int StudentNum;
	
	// 기본형 생성자 → 이 부분은 해당 파일 우클릭 > source > generate constructors from Superclass 에서도 맹글 수 있다 
	public Student() {
		super();
		
	}

	// 모든 멤버 변수를 초기화하는 생성자 → 이 부분은 우클릭 > source > generate constructors using fields 에서도 맹글 수 있음
	public Student(String name, int age, int grade, int studentNum) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
		StudentNum = studentNum;
	}

	// getter, setter 메서드들 → 이 부분은 우클릭 > source > generate getters and setters를 통해 맹글 수 있음
	public String getName() {
		return name;
	}

	public void setName(String name) {	// setter 메서드는 값을 넣는 것이므로 굳이 반환 필요 X 
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