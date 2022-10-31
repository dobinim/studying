package com.kim.ex0604;

import java.util.ArrayList;

public class Student {
	private String name;
	private int age;
	private ArrayList<String> hobbys;
	private double height;
	private double weight;
	
	
	public Student() {
		super();

	}	// 기본 생성자

	
	public Student(String name, int age, ArrayList<String> hobbys) {
		super();
		this.name = name;
		this.age = age;
		this.hobbys = hobbys;
	}	// 파라메터 3개

	public Student(String name, int age, ArrayList<String> hobbys, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.hobbys = hobbys;
		this.height = height;
		this.weight = weight;
	}	// 파라메터 5개 

	
	// getter, setter 메서드
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

	public ArrayList<String> getHobbys() {
		return hobbys;
	}

	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	
} // 클래스 끝
