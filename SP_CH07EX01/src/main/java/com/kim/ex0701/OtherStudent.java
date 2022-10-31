package com.kim.ex0701;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class OtherStudent {
	private String name;
	private int age;
	
	// 기본 생성자
	public OtherStudent() {
		super();
	}

	public OtherStudent(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// getter, setter 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	/* 초기화 후 추가 작업 메서드 , 소멸 후 추가 작업 메서드
	 - 어노테이션 @PostConstruct와 @PreDestroy
	 - Servlet에서도 사용						  */
	
	@PostConstruct	// 이거 에러나면 마우스 올려서 밑에 fix set-up → api 깔라는거 깔면됨 
	public void initMethod() { 
		System.out.println("initMethod()");
	}
	
	@PreDestroy
	public void destroyMethod() {
		System.out.println("destroyMethod()");
	}
	
	
}	// 클래스 끝
