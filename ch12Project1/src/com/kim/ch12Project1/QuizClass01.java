package com.kim.ch12Project1;

import java.util.HashMap;
import java.util.Map;

public class QuizClass01 {

	public static void main(String[] args) {

		// 1번 
		Map<String,Integer> map = new HashMap<String, Integer>();
		// HashMap<String, int> map1 = new HashMap<String, int>(); → 에러
		// 제네릭의 타입변수는 "참조형" 이어야 한다
		
		Product2<String> product = new Product2<String>();	// 2번
		// 인스턴스를 선언, 생성 시 실제 적용할 데이터 타입을 사용
		
		Level myVar = Level.MEDIUM;
		// Level myVar;
		// myVar = Level.MEDIUM;
		System.out.println(myVar); 	// 3번
		
		
		Level[] LevelArr = Level.values();
		for (Level l : LevelArr) {
			System.out.println("상수값은 " + l.name()); // 색인번호는 l.ordinal
		}			// 4번 
		
		 		// 5번
		switch (myVar) {
		case LOW:	// case 문에서는 Level을 생략한 상수명만 사용
			System.out.println("The Level is LOW");
			break;
		case MEDIUM:
			System.out.println("The Level is MEDIUM");
			break;
		default:
			System.out.println("The Level is HIGH");
			break;
		} 
		
	}			// ㅡㅡㅡㅡㅡㅡㅡㅡ 메인 끝

	enum Level {			// 3번
		LOW, MEDIUM, HIGH
}
	
	
}				// ㅡㅡㅡㅡㅡㅡㅡㅡ 클래스 끝

// 제네릭 클래스 생성 시 타입 문자인 T, E, K, V.. 등을 사용하여 만든다
class Product2 <T> { 			// 2 번
	T p;
	T example (T t) {
		T ret = t;
		return ret;
	}
}




/* 
 * 1. 타입 파라메터가 String과 Integer인 map 객체 선언
 * 2. 제네틱클래스 Product2를 만듬
 * 		- 타입파라메터를 이용해 멤버변수 p를 만들어라
 * 		- 타입파라메터를 이용해 리턴타입과 타입파라메터가 적용된 메서드 생성
 * 			( ) example (() t) {
 * 				() ret = t;
 * 				return ret;
 * 			}
 *		- Main 메서드에서 Product 객체를 String타입파라메터를 이용해 만들어라
 * 3. QuizTest 클래스 안에 enum Level을 만들고 상수는 LOW, MEDIUM, HIGH를 만들어라
 * 		- Level 인스턴스 myVar 선언 후 같은 MEDIUM을 주어라
 * 		- myVar 출력
 * 4. enum Level의 상수값을 for문을 이용해 출력
 * 5. Level enum에 switch문 적용
 * 
 */