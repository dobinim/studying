package com.kim.Ch07Project01;

class AAA {	// 	AAA는 BBB의 외부 클래스
	int i = 100;
	
	class BBB { // 	BBB는 AAA의 내부 클래스
		void method() {
//			AAA a = new AAA();
//			System.out.println(a.i);
			System.out.println(i);	// 객체 생성 없이 외부 클래스의 멤버에 접근 가능
		}
	}
}

class CCC { 
	
}

public class InnerTest {

	public static void main(String[] args) {
//		BBB b = new BBB();
//		b.method();
		// → BBB의 멤버를 불러오려면 AAA 객체 생성해서 불러와야함!

	}

}
