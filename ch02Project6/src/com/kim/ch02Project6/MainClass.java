package com.kim.ch02Project6;

import java.util.Scanner; 
/* �� Scanner �� import ���ְ� system ������ ���ϴ°�?
 �� java.lang ���� �͵��� �����Ӱ� �� �� �־ ���� import���� ���� */

public class MainClass {

	public static void main(String[] args) {
		Scanner scanner; // �ܼ�â���� �Է¹��� ���� ó���ϴ� Ŭ���� 
		scanner = new Scanner(System.in); // ���ο� Scanner ��ü ����
	/* �� �̰� ���ٷ� �ٿ��� �� ���� 
		Scanner scanner = new Scanner(System.in);	
		new�� �����ڸ� ȣ���ϴ� Ű���� 
		������ �� Ư�� �޼���. Ŭ���� �̸��� ������ �̸��� ������, ���� Ÿ���� ���� 
		in �� �Է��� �����ϴ� ���� */
		
		System.out.print("�ȳ� : �� �ڸ� ������ �ϳ� �Է����ּ���.>");
		String input = scanner.nextLine();
		/* nextLine() �޼��� 
		 Enter ġ�� ������ �Է��� ���� ��ȯ
		 �Է��� ���� String ���·� ��ȯ
		 �Է� �������� ���		 
		 next() �޼��� �� ������ ������ �Է°��� ��ȯ */
		int num = Integer.parseInt(input); 
		// integer �� �ڹٰ� �����ϸ� ������ ���õ� ���� ó���ϴ� Ŭ����
		// parseint �� ���ڿ� �޼���. ���ڿ��� �������ִ� �޼����̸� ������(int) ���ڿ��� ����

		System.out.println("�Է³��� : " + input);
		System.out.printf("num=%d%n", num);
	}

}
