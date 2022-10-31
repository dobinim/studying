package com.kim.ex0401;

import java.util.ArrayList;

//xml의 bean으로 사용하기 위해 setter, getter로 만듬 
public class MyInfo {
	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobbys;
	private BMICalculator bmiCalculator;
	
	// 생성자
	public MyInfo() {
		super();
		
	}

	// 객체
	public MyInfo(String name, double height, double weight, ArrayList<String> hobbys, BMICalculator bmiCalculator) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.hobbys = hobbys;
		this.bmiCalculator = bmiCalculator;
	}

	
	// getter, setter 메서드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public ArrayList<String> getHobbys() {
		return hobbys;
	}

	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}

	public BMICalculator getBmiCalculator() {
		return bmiCalculator;
	}

	public void setBmiCalculator(BMICalculator bmiCalculator) {
		this.bmiCalculator = bmiCalculator;
	}
	
	
	// 필요한 메서드 추가
	
	public void getInfo() {
		System.out.println("이름 : " + name);
		System.out.println("키 : " + height);
		System.out.println("몸무게 : " + weight);
		System.out.println("취미 : " + hobbys);
		
		bmiCalculation();
		
	}
	
	public void bmiCalculation() {
		bmiCalculator.bmicalculation(weight, height);
	}
}
