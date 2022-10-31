package com.kim.ex0701;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// 스프링 컨테이너 생명주기
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext();
		System.out.println("스프링 컨테이너 생성");
		
		ctx.load("classpath:applicationCTX.xml");
		System.out.println("스프링 컨테이너 설정 내용 로딩");
	
		ctx.refresh();	// Bean 초기화
		// afterPropertiesSet()이 자동적으로 호출됨
		System.out.println("스프링 컨테이너 초기화, Bean 초기화");
		
		Student student = ctx.getBean("student", Student.class);
		System.out.println("스프링 컨테이너 사용");
		
		ctx.close();
		// destroy()가 자동적으로 호출됨
		System.out.println("스프링 컨테이너 소멸, Bean 소멸");

	}

}
