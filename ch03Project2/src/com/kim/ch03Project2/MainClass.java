package com.kim.ch03Project2;

public class MainClass {

	public static void main(String[] args) {
		int i = 5, j = 0;
		
		j = ++i; // �̶� ++�� ������ ���������ڷ�, ���� �� 1�� ����
		System.out.println("j = ++i ���� ��, i = " + i + ", j = " + j);
		
		i = 5;
		j = 0;
		
		j = i++; // �̶� ++�� ������ ���������ڷ�, ���� �� i���� 1�� ���� �� j = 5 ���� �� i�� 1 �����ؼ� i = 6
		System.out.println("j = i++ ���� ��, i = " + i + ", j = " + j);
		
		i = 5;
		j = 5;
		
		System.out.println(i++); // ������ �����������̹Ƿ�, ��� �� 1 ����
		System.out.println(++j); // ������ �����������̹Ƿ�, 1 ���� �� ���
	}

}
