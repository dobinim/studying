package com.kim.ch06Project01;

public class MyMath {
	// static�� ���� �ν��Ͻ� ����޼���� ��� �� �ν��Ͻ�����ó�� �ν���Ʈ.�޼���() 
	long add(long a, long b) { 
		// return type�� long ���� add �޼���� �Ķ���ͷ� long���� a, b�� ���´�
		long result = a + b;
		return result;
		// return type�� long���̹Ƿ� long���� return
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
