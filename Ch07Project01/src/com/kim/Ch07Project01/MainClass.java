package com.kim.Ch07Project01;

public class MainClass {

	public static void main(String[] args) {
		// �ٸ� Ŭ������ ��ü�� ����, ����ϹǷ� '���� ���' (���X)
		SmartTv stv = new SmartTv();
		stv.channel = 10; // SmartTv�� �θ��� Tv�� ����� �������
		stv.channelUp(); // SmartTv�� �θ��� Tv���� ����� ����޼���
		System.out.println(stv.channel);
		
		stv.displayCaption("Hello, world");
		// SmartTv���� ���� �޼��� 
		stv.caption = true; // SmartTv���� ���� ������� 
		stv.displayCaption("Hello, world");

	}

}
