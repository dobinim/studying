package com.kim.ex0701;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class OtherStudent {
	private String name;
	private int age;
	
	// �⺻ ������
	public OtherStudent() {
		super();
	}

	public OtherStudent(String name, int age) {
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
	
	/* �ʱ�ȭ �� �߰� �۾� �޼��� , �Ҹ� �� �߰� �۾� �޼���
	 - ������̼� @PostConstruct�� @PreDestroy
	 - Servlet������ ���						  */
	
	@PostConstruct	// �̰� �������� ���콺 �÷��� �ؿ� fix set-up �� api ���°� ���� 
	public void initMethod() { 
		System.out.println("initMethod()");
	}
	
	@PreDestroy
	public void destroyMethod() {
		System.out.println("destroyMethod()");
	}
	
	
}	// Ŭ���� ��
