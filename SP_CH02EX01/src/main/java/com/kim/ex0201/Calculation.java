package com.kim.ex0201;

public class Calculation {
	private int firstNum;
	private int secondNum;
	
	
	// getter, setter
	public int getFirstNum() {
		return firstNum;
	}
	
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	
	public int getSecondNum() {
		return secondNum;
	}
	
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	
	public void addition() {
		System.out.println("addition()");
		int result = firstNum + secondNum;
		System.out.println(firstNum + " + " + secondNum + " = " + result);
	}
}
