package com.kim.ch03Project3;

public class MainClass {

	public static void main(String[] args) {
		int i = -10; // ������ ������ �� �������� �����̸� = �ʱⰪ
		i = +i; // i�� ��ȣ�� +�� �ٲ�� (*1)
		System.out.println(i);
		
		i = -10; // �� ����
		i = -i; // i�� ��ȣ�� -�� �ٲ�� (*-1)
		System.out.println(i);
	}

}
