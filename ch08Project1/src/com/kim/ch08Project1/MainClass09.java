package com.kim.ch08Project1;

public class MainClass09 {

	public static void main(String[] args) {
		try {
			method1();
		} 
		catch(Exception e) {
			System.out.println("main�޼��忡�� ���ܰ� ó���Ǿ����ϴ�.");
		}
	}

	static void method1() throws Exception {		// ȣ���� �޼���� Exception ����ó�� ����
		try {
			// ����ó���� ���������� �ڽŵ� ����ó���� (��ó��)
			throw new Exception();
		} 
		catch (Exception e) {
			System.out.println("method1 �޼��忡�� ���ܰ� ó���Ǿ����ϴ�.");
			throw e; 
		}
	}
}
