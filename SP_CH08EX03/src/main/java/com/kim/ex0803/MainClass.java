package com.kim.ex0803;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		// ApplicationConfig 클래스에서 만든 Bean 
		AdminConnection connection = ctx.getBean("adminConfig", AdminConnection.class);

		System.out.println("adminID : " + connection.getAdminId());
		System.out.println("adminPW : " + connection.getAdminPw());
		System.out.println("Sub_adminID : " + connection.getSub_adminId());
		System.out.println("Sub_adminPW : " + connection.getSub_adminPw());
		
		ctx.close();
	}

}
