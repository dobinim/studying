package com.kim.ex0401;



public class BMICalculator {
	private double lowWeight;
	private double normal;
	private double overWeight;
	private double obesity;
	
	public BMICalculator() {
		super();
	
	}

	// 모든 멤버변수 사용하는 생성자
	public BMICalculator(double lowWeight, double normal, double overWeight, double obesity) {
		super();
		this.lowWeight = lowWeight;
		this.normal = normal;
		this.overWeight = overWeight;
		this.obesity = obesity;
	}

	// getter, setter 메서드
	public double getLowWeight() {
		return lowWeight;
	}

	public void setLowWeight(double lowWeight) {
		this.lowWeight = lowWeight;
	}

	public double getNormal() {
		return normal;
	}

	public void setNormal(double normal) {
		this.normal = normal;
	}

	public double getOverWeight() {
		return overWeight;
	}

	public void setOverWeight(double overWeight) {
		this.overWeight = overWeight;
	}

	public double getObesity() {
		return obesity;
	}

	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
	
	
	// 필요한 메서드 추가
	
	public void bmicalculation(double weight, double height) {
		double h = height * 0.01;
		double result = weight / (h * h);
		System.out.println("BMI 지수 : " + (int)result);
		
		if(result > obesity)
			System.out.println("당신은 비만입니다.");
		else if (result > overWeight)
			System.out.println("당신은 과체중입니다.");
		else if (result > normal)
			System.out.println("당신은 정상 입니다.");
		else 
			System.out.println("당신은 저체중입니다.");
		
	}
	
}


