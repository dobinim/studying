package com.kim.ch13Project1;

public class MainClass09 {

	public static void main(String[] args) {
		// main�޼��忡 ���� �ڼ� ������ th1, th2 ����
		// �׷�� �켱���� 5�� �����
		Thread09_01 th1 = new Thread09_01();
		Thread09_02 th2 = new Thread09_02();
		th1.start();
		th2.start();
		// main �޼���� ��� ����
		
		try { 
			Thread.sleep(2000);
		} catch (Exception e) {
			e.getMessage();
		}
		System.out.print(" << Main ���� >> ");

	}

}

class Thread09_01 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 300 ; i++) {
			System.out.print("-");
		}
		
		System.out.print("<<th1 ����>>");
	}
}

class Thread09_02 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 300 ; i++) {
			System.out.print("*");
		}
		
		System.out.print("<<th2 ����>>");
	}
}
