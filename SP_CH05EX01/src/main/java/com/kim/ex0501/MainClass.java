package com.kim.ex0501;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
								// ������ �����̳�
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		// StudentInfo�� Student�� ��� �� �����ϰ� ���� (student1 ���� ����ϰ� ����)
		studentInfo.getStudentInfo();

		// student2 bean�� student ��ü�� ���
		Student student2 = ctx.getBean("student2", Student.class);
		studentInfo.setStudent(student2); 		// studentInfo ��ü���� ����ϴ� ��ü�� student2�� ����
		studentInfo.getStudentInfo(); // student2 bean�� �� ���
	}

}
