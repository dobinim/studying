package com.kim.Ch07Project01;

public class MainClass {

	public static void main(String[] args) {
		// 다른 클래스의 객체를 생성, 사용하므로 '포함 방식' (상속X)
		SmartTv stv = new SmartTv();
		stv.channel = 10; // SmartTv의 부모인 Tv에 상속한 멤버변수
		stv.channelUp(); // SmartTv의 부모인 Tv에서 상속한 멤버메서드
		System.out.println(stv.channel);
		
		stv.displayCaption("Hello, world");
		// SmartTv에서 만든 메서드 
		stv.caption = true; // SmartTv에서 만든 멤버변수 
		stv.displayCaption("Hello, world");

	}

}
