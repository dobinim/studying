package com.kim.ch12Project1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated	// 앞으로 사용을 권고하지 않는 클래스
@SuppressWarnings("1111")	// 유효하지 않은 에너테이션은 무시한다.
@TestInfo(testedBy="aaa", testDate=@DateTime(yymmdd="160101",hhmmss="235959"))
public class MainClass04 {

	public static void main(String[] args) {
		//Class class<T>
		Class<MainClass04> cls = MainClass04.class;
		TestInfo anno = cls.getAnnotation(TestInfo.class);
		System.out.println("anno.testedBy() = " + anno.testedBy());
		
	}
}

@Retention(RetentionPolicy.RUNTIME)	// 실행 시 사용 가능하도록 작성
@interface TestInfo {	// 어노테이션 이름이 TestinFo인 어노테이션 선언
	// 어노테이션에 사용하는 속성값은 추상메서드로 정의(추상메서드 이름 = 속성명)
	int count() default 1;	// default는 기본 값으로 값 지정 안할 경우에 갖는 값
	String testedBy();
	String[] testTools() default "JUnit";
	// 배열이므로 원래 { } 안에 넣는데데하나일 때는 생략
	TestType testType() default TestType.FIRST;
	DateTime testDate();
	
}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime {
	String yymmdd();
	String hhmmss();
}

enum TestType {
	FIRST, FINAL 
}
