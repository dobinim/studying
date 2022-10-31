package com.kim.ex0502;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationCTX.xml");
											// ���� ctx ���� ���� �̷��� �ٷ� ���൵ OK.
		
		Pencil pencil = ctx.getBean("pencil", Pencil.class);
				// Ŭ������ �������̽� ���ϸ��� ��� �� �������̽��� ������ ��� Ŭ������ bean ��� ����
				// Bean�� pencil�� Pencil6BWithEraser Ŭ���� 
		pencil.use();
		
		ctx.close();	// ctx�� �ݾ��ֱ�
	
	} // Main �޼����� ��

} // Ŭ������ ��
