package com.kim.ch08Project1;

public class QuizClass1 {

	public static void main(String[] args) {

		int[] myNumbers = new int[] {1,2,3}; // �迭ũ�� 3
		try {
			System.out.println(myNumbers[10]);
			return; // �޼��带 ����������� �� �� ������� ������ �� �߰��Ͻ�
		}
		catch (Exception e) {
			// System.out.println(e.getMessage()); �� ������� ������ �� �߰��Ͻ�
			// Index 10 out of bounds for length 3 
			// �� �迭�� �ִ� 3�ε� �ε��� 10�� (11��°)�� ã�� �� ����. ���� ��Ż! 
			System.out.println("something went wrong.");
			return;		// ���⼭ ����������� �ص� finally���� ���� �� ��������.
		}
		finally { // 2�� ����
			System.out.println("The 'try - catch' is finished.");
		}
	}
}


/* 1. int �迭 myNumbers�� ����� �ʱ�ȭ�� 1,2,3���� �Ѵ�.
 *    �迭 ���ι�ȣ 10���� ���Ҹ� ����� �� ���ܰ� �߻��ϴµ� �̸� ó���϶�. 
 *    try - catch �� ����ϰ� ����ó�� �� "something went wrong." ��� 
 *    
 * 2. 1�� ������ ���ܰ� �ְų� ���ų� The 'try catch' is finished. �� ����ϵ��� �� */


