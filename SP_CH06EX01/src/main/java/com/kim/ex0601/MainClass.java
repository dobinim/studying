package com.kim.ex0601;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// �������� xml�� �� ���� ��������� 2�� ���� 
		String configLocation1 = "classpath:applicationCTX.xml";
		String configLocation2 = "classpath:applicationCTX1.xml";

		// ���� �� �Ķ���ͷ� 2�� ��� ���ڿ��� ��� �� �ΰ� ��θ� �����ϴ� ������ �����̳ʰ� ������
		AbstractApplicationContext ctx =		
				new GenericXmlApplicationContext(configLocation1, configLocation2);
		/* GenericXmlApplicationContext.GenericXmlApplicationContext(String... resourceLocations)
		 	- �Ķ���Ͱ� String... resourceLocationsó�� ������ �� �ڿ� ...�� ���� "������ �Ķ����"��
		 	- ������ �Ķ���� : �Ķ���� ���� ���Ƿ� ��� (VarArg) 								           */
		Student student1 = ctx.getBean("student1", Student.class);
		// ���� student1 : �ڹٿ����� ��ü�� / ���� student1 : xml������ bean id
		System.out.println("student1�� �̸� : " + student1.getName());		// ��� �� ȫ�浿
		System.out.println("student1�� ��� : " + student1.getHobbys());		// ��� �� ����, �丮
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		// studentInfo Bean�� student1 Bean�� ���
		Student student2 = studentInfo.getStudent(); 
		// student1 Bean�� ����� ��ü�̹Ƿ� student2�� student1 ��ü 
		System.out.println("student2�� �̸� : " + student2.getName());		// ��� �� ȫ�浿
		System.out.println("student2�� ��� : " + student2.getHobbys());		// ��� �� ����, �丮

		if (student1.equals(student2)) {
			System.out.println("��, student1�� student2�� �����մϴ�.");
		}
		
		Student student3 = ctx.getBean("student3", Student.class);
		System.out.println("student3�� �̸� : " + student3.getName());
		System.out.println("student3�� ��� : " + student3.getHobbys());
		
		if (student1.equals(student3)) {
			System.out.println("��, student1 �� student3�� �����մϴ�.");
		} else {
			System.out.println("��, student1�� student3�� �ٸ��ϴ�.");
		}
		
		// ������ �̸� ���� 
		Family family = ctx.getBean("family", Family.class);
		System.out.println("�ƹ��� �̸� : " + family.getPapaName());
		System.out.println("��Ӵ� �̸� : " + family.getMamaName());
		System.out.println("���� �̸� : " + family.getSisterName());
		System.out.println("�� �̸� : " + family.getBrotherName());

		ctx.close();
	}	// main �޼��� ��

} // Ŭ���� ��
  