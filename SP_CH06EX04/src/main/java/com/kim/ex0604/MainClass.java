package com.kim.ex0604;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/* ������̼����� ������ Bean �������� */
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		// Java Annotation Class�� ������ Bean �� ������ �����̳� ���� Ŭ���� ���
		Student student1 = ctx.getBean("student1", Student.class);
		// ApplicationConfig���� ���� Bean ��ü 
		
		System.out.println("�̸� : " + student1.getName());
		System.out.println("���� : " + student1.getAge());
		System.out.println("��� : " + student1.getHobbys());
		System.out.println("Ű : " + student1.getHeight());
		System.out.println("������ : " + student1.getWeight());
		
		System.out.println();
		
		/* xml���� ������ Bean �������� */
		Student student2 = ctx.getBean("student2", Student.class);
		
		System.out.println("�̸� : " + student2.getName());
		System.out.println("���� : " + student2.getAge());
		System.out.println("��� : " + student2.getHobbys());
		System.out.println("Ű : " + student2.getHeight());
		System.out.println("������ : " + student2.getWeight());

		ctx.close();
	}	// ���� �޼��� ��

}	// Ŭ���� ��
