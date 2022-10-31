package com.kim.ex0501;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
								// 스프링 컨테이너
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		// StudentInfo는 Student를 사용 → 의존하고 있음 (student1 빈을 사용하고 있음)
		studentInfo.getStudentInfo();

		// student2 bean을 student 객체로 사용
		Student student2 = ctx.getBean("student2", Student.class);
		studentInfo.setStudent(student2); 		// studentInfo 객체에서 사용하는 객체를 student2로 설정
		studentInfo.getStudentInfo(); // student2 bean의 값 출력
	}

}
