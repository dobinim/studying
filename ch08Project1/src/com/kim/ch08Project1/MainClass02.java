package com.kim.ch08Project1;

public class MainClass02 {

	public static void main(String[] args) {
		System.out.println(1);

		try {
			System.out.println(0/0); // ���п��� ó������ ���ϴ� ��� (ArithmeticException ����)
			System.out.println(2);  
			// ������ ���� �߻��ؼ� try��Ͽ��� �ٷ� catch ��� �̵� 
			// 		�� ���� �߻��� ������� �� ������ try��� �� ������ ������� X ! 
		} catch (ArithmeticException ae) {
			// ArithmeticException Ŭ���� = ������꿹�ܸ� ó���ϴ� Ŭ������ java.lang �Ҽ��̴�.
			// ��, import ���� �����൵ OK!
			System.out.println(3);
		} 
		
		System.out.println(4);

	
		System.out.println(0/0); // ����ó�� X 
		// ���� �� runtime error ���� compile error �� �ƴ϶� �տ� x ǥ�ô� �ȶ�!
		/*	Exception in thread "main" java.lang.ArithmeticException: / by zero
		 at com.kim.ch08Project1.MainClass02.main(MainClass02.java:22) 
		 
		 - main method���� by zero (0���� ������) java.lang.ArithmeticException�� �ش��ϴ�
		 	���ܰ� �߻��ߴٴ� �Ҹ�
		 - ��ġ : MainClass02.java:22 �� MainClass02�� 22��° ��	 */
		System.out.println(5); // ������ ���� �߻������� ��� ���� X 

		
		

		
		
		
		
		
		
		
		
		
		
	}
}


