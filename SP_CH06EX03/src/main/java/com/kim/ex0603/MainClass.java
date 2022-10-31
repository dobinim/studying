package com.kim.ex0603;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		// ������ ���� ���� xml ��� �� ������ ��ü
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		// ������̼� �̿��� ������ Bean ���
		Student student1 = ctx.getBean("student1",Student.class);
		
		System.out.println("�̸� : " + student1.getName());
		System.out.println("���� : " + student1.getAge());
		System.out.println("��� : " + student1.getHobbys());
		System.out.println("Ű : " + student1.getHeight());
		System.out.println("������ : " + student1.getWeight());
		
		// xml �̿��� ������ Bean ���
		Student student2 = ctx.getBean("student2", Student.class);

		System.out.println("�̸� : " + student2.getName());
		System.out.println("���� : " + student2.getAge());
		System.out.println("��� : " + student2.getHobbys());
		System.out.println("Ű : " + student2.getHeight());
		System.out.println("������ : " + student2.getWeight());
	}

}
