package com.kim.ch03Project4;

public class MainClass02 {

	public static void main(String[] args) {
		byte a = 10;
		byte b = 20;
		
		/* byte c = a + b; 
		 * byte, short, char 형은 int보다 작으므로 
		 * 연산 전 피연산자를 int로 형변환 한 후에 연산 */
		// byte c = a + b; 하면 에러임. why? → a + b 하면 int형으로 계산하는데 
		// int 형 값을 byte 형 c에 대입하기 때문 → 더 큰 범위의 값이 더 작은 변수에 입력될 수 X
		// byte c = (byte)a + b; 도 에러임.

		byte c = (byte)(a + b);
		System.out.println(c);
		
		int a1 = 2_000_000, b1 = 1_000_000;
		/* long c1 = a1 * b1; 
		 * int * int 는 int인데, 값이 int의 범위를 넘어서 overflow 발생 → -1454759936  */
		long c1 = (long)a1 * b1; 
		/* 하나를 형변환해주게 되면, 연산 시 더 큰 범위의 변수로 자동형변환되어 계산되므로
		 * long * int 니까 값은 long으로 나오게 됨  */
		System.out.println(c1);
		
	}

}
