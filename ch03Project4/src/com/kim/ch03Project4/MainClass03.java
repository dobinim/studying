package com.kim.ch03Project4;

public class MainClass03 {

	public static void main(String[] args) {
		int x = 10;
		int y = 8;
		
		System.out.printf("%d�� %d�� ������, %n", x, y);
		System.out.printf("���� %d�̰�, �������� %d�Դϴ�, %n", x/y, x%y);
		
		// x % y ���� %�� �������� ���ϴ� ��ⷯ�� �����ڷ� ������ ���� ��ȯ�Ѵ�
		/* printf�� ��¹��� ������ ������ ����Ѵ�
		   %d �� ������ ���� ��Ÿ���� ������, %n �ٹٲ� */
		
		boolean b = (0.1 == 0.1f);
		System.out.println(b);
	}

}
