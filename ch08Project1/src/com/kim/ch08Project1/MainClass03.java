package com.kim.ch08Project1;

public class MainClass03 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(0/0); // ���ó�� ���� (ArithmeticException) 
			System.out.println(4);	 // ������ ���� �߻������� ���� X �� �ٷ� catch�� �Ѿ 
		} catch (ArithmeticException ae) {
			if (ae instanceof ArithmeticException) {
				// instanceof �����ڸ� �̿� �� �������� instanceof Ŭ������ 
				// instanceof �����ڸ� �̿��� ae�� ArithmeticException�� �ν��Ͻ����� �Ǵ�
				// ���̹Ƿ� �Ʒ� ���� ���� 
				System.out.println("true");
				// catch���� ó���ϸ� �� ������ catch���� ó������ �ʴ´�.
			}
			System.out.println(ae.toString()); // ���� ����ϴ� class�� ���� ������ ��� 
			System.out.println("ArithmeticException");
		} catch (Exception e) {
			// ù catch��Ͽ��� �̹� ���ܸ� ã�ұ� ������ ��� ������� X 
			System.out.println("Exception"); // ArithmeticException �̿��� ���ܴ� ���⼭ ó��
		}
		System.out.println(6);
	}
}
