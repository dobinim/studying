package com.kim.ch08Project1;

public class MainClass04 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);

	try {
		System.out.println(3);
		System.out.println(0/0);	// ArithmeticException ���� �߻�
		System.out.println(4);
	} catch (ArithmeticException ae) {
		ae.printStackTrace();		
		// ���� ��� Class�� ����(����), ��α��� ���
		// 	cf. System.out.println(ae.toString()); �� ���� ��� Class�� ���θ� ��Ÿ���ְ�, ��ġ�� X  
		System.out.println("���ܸ޽��� : " + ae.getMessage());
	} 
	
	System.out.println(6);
	}
	
}
