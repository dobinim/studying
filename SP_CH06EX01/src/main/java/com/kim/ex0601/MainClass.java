package com.kim.ex0601;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// 설정파일 xml을 두 개로 만들었으니 2개 생성 
		String configLocation1 = "classpath:applicationCTX.xml";
		String configLocation2 = "classpath:applicationCTX1.xml";

		// 생성 시 파라메터로 2개 경로 문자열을 사용 → 두개 모두를 포함하는 스프링 컨테이너가 생성됨
		AbstractApplicationContext ctx =		
				new GenericXmlApplicationContext(configLocation1, configLocation2);
		/* GenericXmlApplicationContext.GenericXmlApplicationContext(String... resourceLocations)
		 	- 파라메터가 String... resourceLocations처럼 데이터 형 뒤에 ...이 오면 "가변형 파라메터"임
		 	- 가변형 파라메터 : 파라메터 수를 임의로 사용 (VarArg) 								           */
		Student student1 = ctx.getBean("student1", Student.class);
		// 앞의 student1 : 자바에서의 객체명 / 뒤의 student1 : xml에서의 bean id
		System.out.println("student1의 이름 : " + student1.getName());		// 출력 → 홍길동
		System.out.println("student1의 취미 : " + student1.getHobbys());		// 출력 → 수영, 요리
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		// studentInfo Bean은 student1 Bean을 사용
		Student student2 = studentInfo.getStudent(); 
		// student1 Bean을 사용한 객체이므로 student2는 student1 객체 
		System.out.println("student2의 이름 : " + student2.getName());		// 출력 → 홍길동
		System.out.println("student2의 취미 : " + student2.getHobbys());		// 출력 → 수영, 요리

		if (student1.equals(student2)) {
			System.out.println("즉, student1과 student2는 동일합니다.");
		}
		
		Student student3 = ctx.getBean("student3", Student.class);
		System.out.println("student3의 이름 : " + student3.getName());
		System.out.println("student3의 취미 : " + student3.getHobbys());
		
		if (student1.equals(student3)) {
			System.out.println("즉, student1 과 student3은 동일합니다.");
		} else {
			System.out.println("즉, student1과 student3은 다릅니다.");
		}
		
		// 가족들 이름 얻어내기 
		Family family = ctx.getBean("family", Family.class);
		System.out.println("아버지 이름 : " + family.getPapaName());
		System.out.println("어머니 이름 : " + family.getMamaName());
		System.out.println("누나 이름 : " + family.getSisterName());
		System.out.println("형 이름 : " + family.getBrotherName());

		ctx.close();
	}	// main 메서드 끝

} // 클래스 끝
  