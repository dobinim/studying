package com.kim.ch06Project01;

public class MainClass05 {

	public static void main(String[] args) {
		MyMath mm = new MyMath();
		// MyMath 클래스의 메서드 call 
		long result1 = mm.add(5L, 3L);
		long result2 = mm.subtract(5L, 3L);
		long result3 = mm.multiply(5L, 3L);
		double result4 = mm.divide(5L, 3L); // 원래는 double 형으로 해서 5d, 3d 해야하지만 자동형변환되니 L형으로 써줘도 상관없음
		
		System.out.println("add(5L, 3L) = " + result1);
		System.out.println("subtract(5L, 3L) = " + result2);
		System.out.println("multiply(5L, 3L) = " + result3);
		System.out.println("divide(5L, 3L) = " + result4);		
	}

}
