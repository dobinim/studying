package com.kim.ch08Project1;

public class MainClass05 {

	public static void main(String[] args) {
		// ������ ���� �߻� �� try ��� �ȿ���!
		try {
			Exception e = new Exception("���Ƿ� �߻�������.");
			// ���� �߻� �� �޽����� �־��ִ� �����ڸ� ����� ���� �ν��Ͻ��� ����
			// java�� �ش� Ŭ���� ���� ������ ������ Ŭ���� ���� �� shift + F2  
			throw e; // throw Ű���带 �̿��� ������(���� �߻�) �ش� catch ����� �޾Ƽ� ó��
		} catch (Exception e) {
			System.out.println("���� �޽��� : " + e.getMessage());
			e.printStackTrace();
		} finally { 	// try-catch���� ���� ���� �������� ������ ��ġ�� �κ���.
			System.out.println("finally"); 
		}
		
		System.out.println("���α׷��� ���� ����Ǿ���.");
	}

} 
