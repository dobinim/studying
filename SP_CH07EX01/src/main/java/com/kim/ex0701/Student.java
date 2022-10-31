package com.kim.ex0701;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class Student implements InitializingBean, DisposableBean {
	private String name;		// Bean�� �ʱ�ȭ, �Ҹ��� ���� �������̽� 
	private int age;
	/* InitializingBean : ������ �����̳� �ʱ�ȭ �� ���� �ʱ�ȭ���ִ� �������̽� 
	 * DisposableBean : ������ �����̳� �Ҹ� �� �ڿ��� �ؼҽ����ִ� �������̽� */
	
	// �⺻������
	public Student() {
		super();
		
	}	

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// InitializingBean�� �߻�޼���
		System.out.println("afterProperTiesSet()");
	}
	
	@Override
	public void destroy() throws Exception {
		// DisposableBean�� �߻�޼���
		System.out.println("destroy()");
	}
	
}	// Ŭ������ ��
