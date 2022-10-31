package com.kim.ch06Project01;

public class MainClass04 { 
	// public 은 접근 제한자로 어떤 패키지의 클래스에서든 접근이 가능하다
	// 클래스의 구성 요소는 멤버 변수, 멤버 메서드, 생성자
	// 생성자가 명시적으로 보이지 않을 때엔 기본 생성자가 있다
	// 필요한 구성 요소만 작성 (메서드와 기본 생성자만 있다)

	public static void main(String[] args) {
		System.out.println("Card.width = " + Card.width); 
		System.out.println("Card.height = " + Card.height);
		// 클래스멤버변수 접근은 <클래스이름.클래스 변수명> 으로 함!
		
		Card c1 = new Card();
		// 클래스라서 C 대문자!
		// Card 클래스의 기본 생성자를 이용해 인스턴스 생성
		c1.kind = "Heart"; // kind는 인스턴스 변수이므로 인스턴스명.인스턴스변수명으로 접근
		c1.number = 7;
		
		Card c2 = new Card();
		c2.kind = "Spade";
		c2.number = 4;
		
		System.out.println("c1은 " + c1.kind + ", " + c1.number + " 이며, 크기는 (" + c1.width + ", " + c1.height + ")" );
		// 클래스 변수는 객체를 만들어 접근해도 된다.
		System.out.println("c2는 " + c2.kind + ", " + c2.number + " 이며, 크기는 (" + c2.width + ", " + c2.height + ")" );
		
		System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다.");
		// c1 객체의 width, height 변경은 static 값을 변경한다
		
		c1.width = 50;
		c1.height = 80;
		
		System.out.println("c1은 " + c1.kind + ", " + c1.number + " 이며, 크기는 (" + c1.width + ", " + c1.height + ")" );
		System.out.println("c2는 " + c2.kind + ", " + c2.number + " 이며, 크기는 (" + c2.width + ", " + c2.height + ")" );
		// static 값이 변경되었기에 c2도 변경되었다
		
	}

}

class Card { 
	// 접근 제한자가 없는 경우는 friendly or default이며 동일 패키지에서만 접근이 가능하다.
	String kind; // 인스턴스 멤버 변수
	int number;  // 인스턴스 멤버 변수
	static int width = 100; // 클래스 멤버 변수 (static, 공유) → 선언 시에 값을 저장
	static int height = 250; // 클래스 멤버 변수 (static, 공유) → 선언 시에 값을 저장
	// card 클래스는 멤버변수와 기본생성자만 있고 메서드는 X
	
	
	
}