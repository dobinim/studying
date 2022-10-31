package com.kim.ch12Project1;

public class MainClass03 {

	public static void main(String[] args) {
		// enum의 인스턴스는 enum이름 인스턴스명으로 만듬
		Direction d1;
		// enum 인스턴스에 값 대입 → enum이름.상수이름
		d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST"); 
		// 상수명이 WEST인 enum 객체를 구하는 메서드
		Direction d3 = Enum.valueOf(Direction.class, "EAST");
		
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		
		System.out.println("d1==d2? " + (d1 == d2));
		// 비교연산 ==은 가능
		System.out.println("d1==d3? " + (d1 == d3));
		System.out.println("d1.equals(d3)? " + d1.equals(d3));
		// equals도 사용 가능
		// System.out.println("d2 > d3? " + (d1 > d3)); // == 이 아닌 비교 연산은 불가능함
		System.out.println("d1.compareTo(d3)? " + (d1.compareTo(d3)));
		System.out.println("d1.compareTo(d2)? " + (d1.compareTo(d2)));
		// 비교 연산을 위해 compareTo메서드는 사용 가능(값은 정수값 0, +, -값)
		
		switch(d1) {
		case EAST:
			System.out.println("The direction is EAST.");
			break;
		case SOUTH:
			System.out.println("The direction is SOUTH.");
			break;
		case WEST:
			System.out.println("The direction is WEST.");
			break;
		case NORTH:
			System.out.println("The direction is NORTH.");
			break;
		default :
			System.out.println("Invalid direction.");
			break;
		}
		
		Direction[] dArr = Direction.values();
		for(Direction d : dArr) {
			System.out.println("name : " + d.name());
			System.out.println("value : " + d.ordinal());
		}
		
		
	}
}

enum Direction { 	// 열거형은 enum 열거형이름 { }
	// 상수값 나열. 상수이므로 모두 대문자로 이름 작성
	// 자동으로 값은 0부터 순서대로 주어진다
	EAST
	,SOUTH
	,WEST
	,NORTH
	
}