package com.kim.ch02Project5;

public class MainClass {

	public static void main(String[] args) {
		String url = "www.codechobo.com";
		float f1 = .10f; // 0.10, 1.0e-1
		float f2 = 1e1f; // = 10.0, 1.0e1, 1.0e+1
		// e�� 10�� n���� ǥ����. 
		float f3 = 3.14e3f;
		double d = 1.23456789;
		
		System.out.printf("fi=%f, %e, %g%n",f1,f1,f1);
		// f1���� %f, %e, %g ������� ��� �� �ٹٲ�
		System.out.printf("f2=%f, %e, %g%n", f2, f2, f2);
		System.out.printf("f3=%f, %e, %g%n", f3, f3, f3);
		System.out.printf("d=%f%n", d); // d ���� float ���·� ��� �� �ٹٲ�
		System.out.printf("d=%14.10f%n", d);
		// d ���� float ������� �Ҽ��� ���� �� 14�ڸ��� �� �� �Ҽ��� ���� 10�ڸ��� ����϶� (�� �ڸ��� ����)
		System.out.printf("[12345678901234567890]%n"); // [] ���� ���� ���ڿ��� ��� �� �ٹٲ�
		System.out.printf("[%s]%n", url);  // url�� ���ڿ� ���·� ������ ���� �� �ٹٲ�
		System.out.printf("[%20s]%n", url); // url�� ���ڿ��� ǥ���ϵ� �� �ڸ����� 20�̸� '������' ���� �� �ٹٲ�
		System.out.printf("[%-20s]%n", url); // url�� ���ڿ� ������ �� 20���ڷ� '����' ���� �� �ٹٲ�
		System.out.printf("[%.8s]%n", url); // ���ʿ��� 8���ڸ� ���
	}

}
