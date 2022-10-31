package com.kim.ch02Project5;

public class MainClass {

	public static void main(String[] args) {
		String url = "www.codechobo.com";
		float f1 = .10f; // 0.10, 1.0e-1
		float f2 = 1e1f; // = 10.0, 1.0e1, 1.0e+1
		// e는 10의 n승을 표현함. 
		float f3 = 3.14e3f;
		double d = 1.23456789;
		
		System.out.printf("fi=%f, %e, %g%n",f1,f1,f1);
		// f1값을 %f, %e, %g 방식으로 출력 후 줄바꿈
		System.out.printf("f2=%f, %e, %g%n", f2, f2, f2);
		System.out.printf("f3=%f, %e, %g%n", f3, f3, f3);
		System.out.printf("d=%f%n", d); // d 값을 float 형태로 출력 후 줄바꿈
		System.out.printf("d=%14.10f%n", d);
		// d 값을 float 방식으로 소수점 포함 총 14자리의 수 중 소수점 이하 10자리로 출력하라 (빈 자리는 공백)
		System.out.printf("[12345678901234567890]%n"); // [] 안의 것을 문자열로 출력 후 줄바꿈
		System.out.printf("[%s]%n", url);  // url을 문자열 형태로 오른쪽 정렬 후 줄바꿈
		System.out.printf("[%20s]%n", url); // url을 문자열로 표시하되 총 자리수가 20이며 '오른쪽' 정렬 후 줄바꿈
		System.out.printf("[%-20s]%n", url); // url을 문자열 형태의 총 20글자로 '왼쪽' 정렬 후 줄바꿈
		System.out.printf("[%.8s]%n", url); // 왼쪽에서 8글자만 출력
	}

}
