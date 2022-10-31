package com.kim.ex0602;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// @Configuration : ApplicationConfig Ŭ������ ������ ���� ���� Ŭ�������� ��Ÿ���� ������̼�
public class ApplicationConfig {
		// bean�� �����ϴ� java Ŭ����

	@Bean
	// @Bean : �������� bean�� �����ϴ� ������̼�
	public Student student1() {
		// ���� Ÿ�� : bean�� Ŭ������
		// �޼��� �̸��� bean �̸�
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("����");
		hobbys.add("�丮");
		
		Student student = new Student("ȫ�浿", 20, hobbys);
		
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
	
	@Bean
	public Student student2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("����");
		hobbys.add("���ǰ���");
		
		Student student = new Student("��ö��", 22, hobbys);	// �����ڷ� �Ӽ� ����
		
		student.setHeight(170);
		student.setWeight(70);
		
		return student;		// Bean student2 ����
	}
}