package com.kim.ex0301;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*  
		 - 기존 Java 방식
		 MyCalculator myCalculator = new MyCalculator();
		 → MyCalculator 객체 생성
		 myCalculator.setCalculator(new MyCalculator()); 
		 			→ setCalculator : 객체를 받아 calculator에 저장
		 myCalculator.setFirstNum(10);
		 			→ MyCalculator의 FirstNum으로 10 저장
		 myCalculator.setSecondNum(2);
		 			→ MyCalculator의 SecondNum으로 2 저장
		 myCalculator.add();
		 			→ add 수행
		 */

		
									// Spring 방식 : 주입을 통한 구현
		
		// 1. 스프링 설정파일의 위치를 문자열로 지정
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		/* AbstractApplicationContext 
		 - 추상 클래스. IOC 컨테이너 설정 파일(applicationCTX.xml)의 내용을 로딩해 객체를 생성하는 인터페이스 
		 - 스프링 컨테이너 → 생성된 빈(Bean)에 추가 기능을 부여
		 * GenericXmlApplicationContext()
		 - 앞의 추상 클래스를 구현한 클래스. 주입된 객체를 생성 							  	  	    */
		MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
										/* getBean("bean클래스의 id", bean클래스) */
		myCalculator.add();
		
	}

}


/*
	스프링 IOC 컨테이너의 설정 파일(xml) → src/main/resources에 생성
 	AbstractApplicationContext 객체를 GenericXmlApplicationContext 클래스로 생성
 		→ 이때, 파라메터로 해당 설정 파일(xml)의 경로를 사용
 	스프링 컨테이너 객체를 얻은 후 (여기선 MyCalculator) getBean("bean이름", 클래스파일명)으로 객체 주입받음  
 */