package com.kim.ch02Project4;

public class MainClass {

	public static void main(String[] args) {
		int x = 10, y = 5;
		// ������ ������ ���� ������ �� �̷��� �Ѳ����� ������ ���� ����
		System.out.println("x= " + x);
		System.out.println("y= " + y);
		
		int tmp = x; // �� ���� ���� ��ȯ�ϱ� ���� �ӽ� ���� tmp ����
		x = y; // y�� ���� x�� ����
		y = tmp; // tmp�� ����� x�� ���� y�� ����
		
		System.out.println("x= " + x);
		System.out.println("y= " + y);
		
	}

}
