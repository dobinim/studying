package com.kim.ex0702;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Student student1 = ctx.getBean("student", Student.class);
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		System.out.println("============================");
		
		Student student2 = ctx.getBean("student", Student.class);
		// bean은 동일한 student를 사용
		student2.setName("홍길순");
		student2.setAge(10);

		// student2 객체로 변경했으나 student1도 변경됨 (singleton이라 동일한 객체가 생성됨)
		// 	 → so, student1 객체도 변경되어버림!
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		System.out.println("============================");
		
		// scope가 singleton이므로 하나의 동일한 bean으로 만든 자바객체는 모두 "동일"
		if (student1.equals(student2)) {
			System.out.println("student1이 변경되었습니다.");
			System.out.println("student1과 student2가 동일합니다.");
		} else 
			System.out.println("student1과 student2가 다릅니다.");
		
		ctx.close();

	}

}
