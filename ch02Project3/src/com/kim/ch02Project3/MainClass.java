package com.kim.ch02Project3;

public class MainClass {
	// { } ��� �ۿ��� ����Ǵ� ������ ��������(global variable)�� �⺻���� ������
	/* �⺻��
	 * boolean �� false, ������(�������Ǽ���)�� 0, char�� 'u|0000' (����), �������� null
	 * */
	static int age;
	static String name = "kim";
	static char ch;
	// static method �ȿ����� static �����鸸 �� �� �ֱ� ������ 
	// �տ� static �ٿ���
	
	public static void main(String[] args) {
		/* �޼��� �ȿ��� �����ϴ� ������ ��� ��������(local variable)��  
		 ����� �Բ� �ʱ�ȭ�ؾ� �Ѵ� */
	
		System.out.println(age); // age�� �⺻ ���̹Ƿ� 0
		System.out.println(name);
		System.out.println(ch);
		
		String name1 = "Ja" + "va"; // ���ڿ� "Ja" �� "va"�� ���տ����ڷ� ����
		String str = name1 + 8.0; // ���ڿ� + ���� �� ���ڸ� ���ڿ��� ��ȯ�� ����, ��, name1 + "8.0"
		
		System.out.println(name1);
		System.out.println(str);
		
		System.out.println(7 + " ");
		System.out.println(" " + 7);
		System.out.println(7 + "");
		System.out.println("" + 7);
		System.out.println("" + "");
		System.out.println(7 + 7 + "");
		System.out.println("" + 7 + 7);
	}

}
