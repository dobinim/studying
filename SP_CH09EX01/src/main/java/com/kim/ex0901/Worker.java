package com.kim.ex0901;

public class Worker {
	private String name;
	private int age;
	private String job;
	
	
	public Worker() {
		super();
	}
	
	
	public Worker(String name, int age, String job) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
	}
	
	
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
	// getter, setter 외 추가 메서드
	
	public void getWorkerInfo() {
		System.out.println("이름 : " + getName());
		System.out.println("나이 : " + getAge());
		System.out.println("직업 : " + getJob());
	}
}
