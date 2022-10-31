package com.kim.ex0702;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Student student1 = ctx.getBean("student", Student.class);
		System.out.println("�̸� : " + student1.getName());
		System.out.println("���� : " + student1.getAge());
		System.out.println("============================");
		
		Student student2 = ctx.getBean("student", Student.class);
		// bean�� ������ student�� ���
		student2.setName("ȫ���");
		student2.setAge(10);

		// student2 ��ü�� ���������� student1�� ����� (singleton�̶� ������ ��ü�� ������)
		// 	 �� so, student1 ��ü�� ����Ǿ����!
		System.out.println("�̸� : " + student1.getName());
		System.out.println("���� : " + student1.getAge());
		System.out.println("============================");
		
		// scope�� singleton�̹Ƿ� �ϳ��� ������ bean���� ���� �ڹٰ�ü�� ��� "����"
		if (student1.equals(student2)) {
			System.out.println("student1�� ����Ǿ����ϴ�.");
			System.out.println("student1�� student2�� �����մϴ�.");
		} else 
			System.out.println("student1�� student2�� �ٸ��ϴ�.");
		
		ctx.close();

	}

}
