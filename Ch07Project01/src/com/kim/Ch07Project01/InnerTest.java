package com.kim.Ch07Project01;

class AAA {	// 	AAA�� BBB�� �ܺ� Ŭ����
	int i = 100;
	
	class BBB { // 	BBB�� AAA�� ���� Ŭ����
		void method() {
//			AAA a = new AAA();
//			System.out.println(a.i);
			System.out.println(i);	// ��ü ���� ���� �ܺ� Ŭ������ ����� ���� ����
		}
	}
}

class CCC { 
	
}

public class InnerTest {

	public static void main(String[] args) {
//		BBB b = new BBB();
//		b.method();
		// �� BBB�� ����� �ҷ������� AAA ��ü �����ؼ� �ҷ��;���!

	}

}
