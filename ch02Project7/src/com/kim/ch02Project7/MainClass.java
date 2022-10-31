package com.kim.ch02Project7;

public class MainClass {

	public static void main(String[] args) {
		
		short sMin = -32768, sMax = 32767;
		// short 는 2바이트(16비트)이므로 표시 가능한 값이 2^16개, 즉, 65536개고,
		// 표현 가능 범위는 -2^16 (-32768) ~ 2^16-1 (32767) 까지다 
		char cMin = 0, cMax = 65535; 
		// 문자형은 부호가 없는 정수 (-가 X)라 0부터 시작, 문자 뿐 아니라 유니코드를 이용해 숫자로도 나타낼 수 있다
		System.out.println("sMin = " + sMin);
		System.out.println("sMin-1 = " + (short)(sMin-1));
		// 최소값에서 -1하면 최대값으로 나온다  (overflow)
		System.out.println("sMax = " + sMax);
		System.out.println("sMax + 1 = " + (short)(sMax+1));
		// 최대값에서 +1하면 최소값으로 나온다 (overflow) → 형변환 처리 
		System.out.println("cMin = " + (int)cMin);
		// char을 int형으로 형변환하는 int형변환
		System.out.println("cMin - 1 = " + (int)--cMin);
		// --는 결합연산자로 1을 감소시키는 연산자
		// 최대값으로 나옴 (cMin - 1 = cMax)
		System.out.println("cMax = " + cMax);
		// cMax는 문자형 ?으로, 정수타입으로 하면 65535가 됨
		System.out.println("cMax + 1 = " + (int)++cMax);
		// ++는 연산자로 1을 더하는 연산자
		// 최소값으로 나옴 (cMax + 1 = cMin)
		System.out.println((char)65); // 더 큰 int형 64를 적은 char형으로 형변환
		System.out.println((int)1.5f); // 더 큰 float형을 int형으로 형변환
		
		// 형변환 => (형변환하고자 하는 변수의 형태)값  예)(char)65 / (int)A 같은 것들 
		
	}

}
