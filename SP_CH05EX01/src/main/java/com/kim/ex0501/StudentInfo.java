package com.kim.ex0501;

public class StudentInfo {
	private Student student;
	// Student 객체를 사용중이다 → StudentInfo는 Student에 의존하고 있다. (의존 관계)

	public StudentInfo() {
		super();
		
	}
	
	public StudentInfo(Student student) {	// Student 객체를 파라메터로 갖는 StudentInfo
		super();
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public void getStudentInfo() {
		if (student != null) {
			System.out.println("이름 : " + student.getName());
			System.out.println("나이 : " + student.getAge());
			System.out.println("학년 : " + student.getGradeNum());
			System.out.println("반 : " + student.getClassNum());
			System.out.println("==============================");
		}
	}
	
}