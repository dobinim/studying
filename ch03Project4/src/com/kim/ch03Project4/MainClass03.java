package com.kim.ch03Project4;

public class MainClass03 {

	public static void main(String[] args) {
		int x = 10;
		int y = 8;
		
		System.out.printf("%d를 %d로 나누면, %n", x, y);
		System.out.printf("몫은 %d이고, 나머지는 %d입니다, %n", x/y, x%y);
		
		// x % y 에서 %는 나머지를 구하는 모듈러스 연산자로 나머지 값을 반환한다
		/* printf는 출력문의 형식을 지정시 사용한다
		   %d → 정수형 값을 나타내는 지시자, %n 줄바꿈 */
		
		boolean b = (0.1 == 0.1f);
		System.out.println(b);
	}

}
