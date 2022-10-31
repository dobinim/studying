package com.kim.ex0604;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/* 어노테이션으로 설정한 Bean 가져오기 */
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		// Java Annotation Class로 구현한 Bean 용 스프링 컨테이너 생성 클래스 사용
		Student student1 = ctx.getBean("student1", Student.class);
		// ApplicationConfig에서 만든 Bean 객체 
		
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		System.out.println("취미 : " + student1.getHobbys());
		System.out.println("키 : " + student1.getHeight());
		System.out.println("몸무게 : " + student1.getWeight());
		
		System.out.println();
		
		/* xml으로 설정한 Bean 가져오기 */
		Student student2 = ctx.getBean("student2", Student.class);
		
		System.out.println("이름 : " + student2.getName());
		System.out.println("나이 : " + student2.getAge());
		System.out.println("취미 : " + student2.getHobbys());
		System.out.println("키 : " + student2.getHeight());
		System.out.println("몸무게 : " + student2.getWeight());

		ctx.close();
	}	// 메인 메서드 끝

}	// 클래스 끝
