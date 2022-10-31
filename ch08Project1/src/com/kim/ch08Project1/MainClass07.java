package com.kim.ch08Project1;

public class MainClass07 {

	public static void main(String[] args) throws Exception {
		// throws exception�� ����ó���� main�� ȣ���� ������ ����(jvm)
		method1();
	}

	static void method1() throws Exception {
		method2(); // ���⵵ try-catch�� ������ ���� �޼��忡 ���� (main)
	}
	
	static void method2() throws Exception {
		throw new Exception();
		// ���Ƿ� Exception ���ܸ� �߻��������� try-catch�� �ƴ� throws�� ���ܸ� 
		// �ڱ⸦ ȣ���� �޼��忡 ���� (method1) 
	}

	/* ��µǴ� ���� �ڵ�
	 Exception in thread "main" java.lang.Exception
	at com.kim.ch08Project1.MainClass07.method2(MainClass07.java:15)
	at com.kim.ch08Project1.MainClass07.method1(MainClass07.java:11)
	at com.kim.ch08Project1.MainClass07.main(MainClass07.java:7)
			�� ���� �ڱ⸦ ȣ���� ���� Ŭ������ �����ϴٰ� main���� ����
	 */
}
