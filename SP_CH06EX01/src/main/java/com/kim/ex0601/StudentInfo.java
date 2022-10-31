package com.kim.ex0601;

public class StudentInfo {
	private Student student;
	
	// 생성자가 최소 1개라도 존재하면 기본형 생성자 사용 시 필수로 정의해줘야 한다!
	public StudentInfo() {
		super();
	}

	public StudentInfo(Student student) {
		super();
		this.student = student;
	}
	
	// getter, setter 메서드
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


}
