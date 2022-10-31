package com.kim.ch13Project1;

public class MainClass01 {
	
	public static void main(String[] args) {
		Thread01 t1 = new Thread01();
		// Thread Ŭ������ ����� Ŭ������ �ν��Ͻ� (��, ������ ��ü)�� Ŭ������ �������ڷ� �����
		t1.start(); // thread ���� run �޼��� ����
		
		// runnable�� ������ Ŭ������ thread ��ü
		Runnable r = new Thread02(); // ������ Ŭ������ �̿��� Runnable �������̽��� ��ü ����
		Thread t2 = new Thread(r);	 // Thread�� ������ �� �Ű������� Runnable�� �� ������ �̿� 
		t2.start();					 // Thread02�� run() ȣ��
		System.out.println("main thread");
	}

}

class Thread01 extends Thread { 
	//	java.lang�� ���� �⺻ Ŭ����
	//	public class Thread extends Object implements Runnable
	//	Thread �۾��� ó���ϴ� run �޼��带 �������Ͽ��� �����尡 �� ���� ����
	@Override
	public void run() {
		System.out.println(getName());
		// ����Ŭ�������� ����� getName()�� Thread�� �̸��� ��ȯ
		// Thread �̸��� ������� (�⺻��) Thread-0 ���·� �־�����
	}
}

class Thread02 implements Runnable {
	//java.lang�� �ִ� �������̽�
	// @FunctionalInterface public interface Runnable �߻� �޼��尡 �ϳ��� �ִ� �޼���
	@Override
	public void run() {
		for(int i = 0; i <5 ; i++ ) {
			System.out.println(Thread.currentThread().getName());
			// Thread Ŭ������ static�޼��� currentThread()�� ���� �������� Thread ��ü�� ��ȯ
		}
	}
}