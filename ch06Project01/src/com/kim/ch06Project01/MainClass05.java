package com.kim.ch06Project01;

public class MainClass05 {

	public static void main(String[] args) {
		MyMath mm = new MyMath();
		// MyMath Ŭ������ �޼��� call 
		long result1 = mm.add(5L, 3L);
		long result2 = mm.subtract(5L, 3L);
		long result3 = mm.multiply(5L, 3L);
		double result4 = mm.divide(5L, 3L); // ������ double ������ �ؼ� 5d, 3d �ؾ������� �ڵ�����ȯ�Ǵ� L������ ���൵ �������
		
		System.out.println("add(5L, 3L) = " + result1);
		System.out.println("subtract(5L, 3L) = " + result2);
		System.out.println("multiply(5L, 3L) = " + result3);
		System.out.println("divide(5L, 3L) = " + result4);		
	}

}