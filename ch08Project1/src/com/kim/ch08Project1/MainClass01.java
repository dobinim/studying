package com.kim.ch08Project1;

public class MainClass01 {

	public static void main(String[] args) {
		System.out.println(1);
		
		try {
			// try�� ���ܹ߻����ɼ��� �ִ� �ڵ带 �ۼ��ϴµ� print �������� ���ܹ߻� X�̹Ƿ� catch�� ��� ����
			System.out.println(2);
			System.out.println(3);
		} catch(Exception e) { 
			// Exception �� ����ó�� Ŭ������, ����Ŭ������ �̸� ����� ����Ŭ������ �������� ���� �޴´�.
			System.out.println(4); // ���� �߻� �� ó���� �ڵ�
		}
		
		// try-catch���� ��� �ۿ��� ����Ǵ� �ڵ�
		System.out.println(5);
	}

}
