package com.kim.ex0502;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationCTX.xml");
											// 따로 ctx 설정 없이 이렇게 바로 써줘도 OK.
		
		Pencil pencil = ctx.getBean("pencil", Pencil.class);
				// 클래스에 인터페이스 파일명을 사용 → 인터페이스를 구현한 모든 클래스의 bean 사용 가능
				// Bean인 pencil은 Pencil6BWithEraser 클래스 
		pencil.use();
		
		ctx.close();	// ctx는 닫아주기
	
	} // Main 메서드의 끝

} // 클래스의 끝
