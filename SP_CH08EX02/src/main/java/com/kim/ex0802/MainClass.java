package com.kim.ex0802;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		AdminConnection connection = ctx.getBean("adminConnection", AdminConnection.class);
		
		System.out.println("admin ID :  " + connection.getAdminId());
		System.out.println("admin PW :  " + connection.getAdminPw());
		System.out.println("Sub_admin ID :  " + connection.getSub_adminId());
		System.out.println("Sub_admin PW :  " + connection.getSub_adminPw());
		
		ctx.close();
	}
}
