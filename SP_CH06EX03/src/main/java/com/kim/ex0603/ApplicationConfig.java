package com.kim.ex0603;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration	// ������ IOC ���� ���Ϸ� ����� ������̼�
public class ApplicationConfig {

	@Bean // ������ �����̳��� Bean�� ����� ������̼�
	// �޼���� Bean�� Ŭ������ ����Ÿ������ �ϰ�, �޼��� �̸� = Bean �̸����� ����
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("����");
		hobbys.add("�丮");
		Student student = new Student("ȫ�浿", 20, hobbys);
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
	
}
