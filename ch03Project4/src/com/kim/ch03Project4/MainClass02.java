package com.kim.ch03Project4;

public class MainClass02 {

	public static void main(String[] args) {
		byte a = 10;
		byte b = 20;
		
		/* byte c = a + b; 
		 * byte, short, char ���� int���� �����Ƿ� 
		 * ���� �� �ǿ����ڸ� int�� ����ȯ �� �Ŀ� ���� */
		// byte c = a + b; �ϸ� ������. why? �� a + b �ϸ� int������ ����ϴµ� 
		// int �� ���� byte �� c�� �����ϱ� ���� �� �� ū ������ ���� �� ���� ������ �Էµ� �� X
		// byte c = (byte)a + b; �� ������.

		byte c = (byte)(a + b);
		System.out.println(c);
		
		int a1 = 2_000_000, b1 = 1_000_000;
		/* long c1 = a1 * b1; 
		 * int * int �� int�ε�, ���� int�� ������ �Ѿ overflow �߻� �� -1454759936  */
		long c1 = (long)a1 * b1; 
		/* �ϳ��� ����ȯ���ְ� �Ǹ�, ���� �� �� ū ������ ������ �ڵ�����ȯ�Ǿ� ���ǹǷ�
		 * long * int �ϱ� ���� long���� ������ ��  */
		System.out.println(c1);
		
	}

}
