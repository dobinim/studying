package com.kim.ch08Project1;

public class MainClass06 {

	public static void main(String[] args) {
		// ���ܴ� Exception �迭�� RuntimeException �迭�� ���е�
		Exception e = new Exception();
		// throw e;
		// throw new Exception(); ���� �ѹ��� ó���� �� ����
		// Exception ���ܴ� try-catch �� ���� ó���� ���� ������ ������ ���� �߻� (checked ����)
		
		throw new RuntimeException();
		// ������ ������ �߻����� X, ���α׷� ���� �� ���� �߻�(unchecked ����)
		// �����߿��� ������ �߻��ϹǷ� �ش� ���ܸ� ó�� 
		

	}
}
