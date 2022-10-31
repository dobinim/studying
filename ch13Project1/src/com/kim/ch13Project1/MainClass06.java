package com.kim.ch13Project1;

public class MainClass06 {

	public static void main(String[] args) {
		Thread06_1 th1 = new Thread06_1();
		Thread06_2 th2 = new Thread06_2();
		// Main�������� �켱������ �⺻�� 5�̴�. NORM_PRIORITY
		// main�����尡 th1, th2 �����带 ����� 5�� ���
		
		th2.setPriority(7);	// th2�� �켱������ 7�� ����
		System.out.println("Priority of th1(-) : " + th1.getPriority());
		System.out.println("Priority of th2(|) : " + th2.getPriority());
		
		th1.start();
		th2.start();
		
		// windows os�� cpuŸ���� �����ϱ� ������ �켱������ �� �������� ���� �ƴϴ�.
	}
}
	

class Thread06_1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 300 ; i++) {
			System.out.print("-");
			for (int x = 0; x < 10000000; x++); 	// 	{ } ���� ����
		}
	}
}


class Thread06_2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 300 ; i++) {
			System.out.print("|");
			for (int x = 0; x < 10000000; x++);
		}
	}
}
