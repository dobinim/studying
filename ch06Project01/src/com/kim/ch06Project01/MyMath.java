package com.kim.ch06Project01;

public class MyMath {
	// static이 없는 인스턴스 멤버메서드로 사용 시 인스턴스변수처럼 인스턴트.메서드() 
	long add(long a, long b) { 
		// return type이 long 형인 add 메서드는 파라메터로 long형인 a, b를 갖는다
		long result = a + b;
		return result;
		// return type이 long형이므로 long형을 return
		}
	
	long subtract(long a, long b) {
		return a - b;
	}
	
	long multiply(long a, long b) {
		return a * b;
	}
	
	double divide(double a, double b) {
		return a / b;
	}
}
