package com.kim.ex0602;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// @Configuration : ApplicationConfig 클래스가 스프링 설정 관련 클래스임을 나타내는 어노테이션
public class ApplicationConfig {
		// bean을 생성하는 java 클래스

	@Bean
	// @Bean : 스프링의 bean을 설정하는 어노테이션
	public Student student1() {
		// 리턴 타입 : bean의 클래스형
		// 메서드 이름은 bean 이름
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
		
		Student student = new Student("홍길동", 20, hobbys);
		
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
	
	@Bean
	public Student student2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("조깅");
		hobbys.add("음악감상");
		
		Student student = new Student("김철수", 22, hobbys);	// 생성자로 속성 설정
		
		student.setHeight(170);
		student.setWeight(70);
		
		return student;		// Bean student2 설정
	}
}