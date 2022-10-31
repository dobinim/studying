package com.kim.ex0301;

// IOC 컨테이너에서 bean으로 사용될 클래스 → 생성자와 setter 메서드가 있어야 함
public class MyCalculator {
	// 멤버 변수
	Calculator calculator; // 외부 클래스 객체
	
	// 기본형 멤버 변수 firstNum과 secondNum 선언
	private int firstNum;	
	private int secondNum;
	
	// 생성자
	public MyCalculator() {
		super();
	}

	// getter, setter 메서드
	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

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
	
	
	// 추가 필요메서드
	
	public void add() {
		calculator.addition(firstNum, secondNum);
	}
}
