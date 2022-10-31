package com.kim.Ch07Project01;

public class MainClass02 {

	public static void main(String[] args) {
		Child c = new Child();
		// 포함 방식
		c.method();
	}

}

class Parent {
	int x = 10;
}

class Child extends Parent {
	int x = 20; // 부모클래스의 멤버변수를 중첩 정의해 부모 변수는 가려짐 (overriding)
	void method() {
		System.out.println("x = " + x);
		System.out.println("this.x = " + this.x);
		System.out.println("super.x = " + super.x);
	}
}
