package com.kim.ch13Project1;

public class MainClass02 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		// 현재까지의 posix타입(1970.1.10시부터 지금까지 경과한 밀리세컨드값
		
		for (int i = 0 ; i < 300 ; i++)
			System.out.print("-");
		
		System.out.println(); 			// 띄어쓰기 ㅡㅡㅡㅡㅡㅡㅡ
		System.out.println("소요시간 1 : " + (System.currentTimeMillis() - startTime));
		
		for (int i = 0 ; i < 300 ; i++)
			System.out.print("|");
		
		System.out.println();			// 띄어쓰기 ㅡㅡㅡㅡㅡㅡㅡ
		System.out.println("소요시간 2 : " + (System.currentTimeMillis() - startTime));

	}

}
