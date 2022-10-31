package com.kim.ch03Project2;

public class MainClass {

	public static void main(String[] args) {
		int i = 5, j = 0;
		
		j = ++i; // 이때 ++는 전위형 증가연산자로, 대입 전 1을 증가
		System.out.println("j = ++i 실행 후, i = " + i + ", j = " + j);
		
		i = 5;
		j = 0;
		
		j = i++; // 이때 ++는 후위형 증가연산자로, 대입 후 i값에 1을 증가 → j = 5 대입 후 i에 1 증가해서 i = 6
		System.out.println("j = i++ 실행 후, i = " + i + ", j = " + j);
		
		i = 5;
		j = 5;
		
		System.out.println(i++); // 후위형 증가연산자이므로, 출력 후 1 증가
		System.out.println(++j); // 전위형 증가연산자이므로, 1 증가 후 출력
	}

}
