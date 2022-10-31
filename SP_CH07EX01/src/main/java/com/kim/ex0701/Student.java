package com.kim.ex0701;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class Student implements InitializingBean, DisposableBean {
	private String name;		// Bean의 초기화, 소멸을 위한 인터페이스 
	private int age;
	/* InitializingBean : 스프링 컨테이너 초기화 시 빈을 초기화해주는 인터페이스 
	 * DisposableBean : 스프링 컨테이너 소멸 시 자원을 해소시켜주는 인터페이스 */
	
	// 기본생성자
	public Student() {
		super();
		
	}	

	public Student(String name, int age) {
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
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// InitializingBean의 추상메서드
		System.out.println("afterProperTiesSet()");
	}
	
	@Override
	public void destroy() throws Exception {
		// DisposableBean의 추상메서드
		System.out.println("destroy()");
	}
	
}	// 클래스의 끝
