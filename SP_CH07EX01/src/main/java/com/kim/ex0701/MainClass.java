package com.kim.ex0701;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// ������ �����̳� �����ֱ�
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext();
		System.out.println("������ �����̳� ����");
		
		ctx.load("classpath:applicationCTX.xml");
		System.out.println("������ �����̳� ���� ���� �ε�");
	
		ctx.refresh();	// Bean �ʱ�ȭ
		// afterPropertiesSet()�� �ڵ������� ȣ���
		System.out.println("������ �����̳� �ʱ�ȭ, Bean �ʱ�ȭ");
		
		Student student = ctx.getBean("student", Student.class);
		System.out.println("������ �����̳� ���");
		
		ctx.close();
		// destroy()�� �ڵ������� ȣ���
		System.out.println("������ �����̳� �Ҹ�, Bean �Ҹ�");

	}

}
