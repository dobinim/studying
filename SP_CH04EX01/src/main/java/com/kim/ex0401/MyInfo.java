package com.kim.ex0401;

import java.util.ArrayList;

//xml�� bean���� ����ϱ� ���� setter, getter�� ���� 
public class MyInfo {
	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobbys;
	private BMICalculator bmiCalculator;
	
	// ������
	public MyInfo() {
		super();
		
	}

	// ��ü
	public MyInfo(String name, double height, double weight, ArrayList<String> hobbys, BMICalculator bmiCalculator) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.hobbys = hobbys;
		this.bmiCalculator = bmiCalculator;
	}

	
	// getter, setter �޼���
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
	
	
	// �ʿ��� �޼��� �߰�
	
	public void getInfo() {
		System.out.println("�̸� : " + name);
		System.out.println("Ű : " + height);
		System.out.println("������ : " + weight);
		System.out.println("��� : " + hobbys);
		
		bmiCalculation();
		
	}
	
	public void bmiCalculation() {
		bmiCalculator.bmicalculation(weight, height);
	}
}
