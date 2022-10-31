package com.kim.ex1601;

public class People {
	// 멤버 변수
	private String name;
	private String id;
	private String address;
	private int age;
	
	// 기본 생성자
	public People() {
		super();
		
	}

	// 모든 멤버 변수를 초기화하는 생성자
	public People(String name, String id, String address, int age) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
		this.age = age;
	}

	// getter, setter 메서드들
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}


