package com.kim.ex0601;

public class StudentInfo {
	private Student student;
	
	// �����ڰ� �ּ� 1���� �����ϸ� �⺻�� ������ ��� �� �ʼ��� ��������� �Ѵ�!
	public StudentInfo() {
		super();
	}

	public StudentInfo(Student student) {
		super();
		this.student = student;
	}
	
	// getter, setter �޼���
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


}
