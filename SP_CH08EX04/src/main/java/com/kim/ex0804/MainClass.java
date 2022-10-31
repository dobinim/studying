package com.kim.ex0804;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String config = null;
		System.out.println("콘솔창에 입력해주세요.");
		Scanner scanner = new Scanner(System.in);	// 키보드 입력처리 객체
		String str = scanner.next(); // 입력된 값. 입력 후 엔터 후 
		if (str.equals("dev")) { 
			config = "dev";
		} else if (str.equals("run")) {
			config = "run";
		}
		
		scanner.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		// getEnvironment()는 ConfigurableEnvironment 객체를 반환하고,
		// setActiveProfiles(config)는 xml의 profile이 config인 xml 선택
		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
		// 2개의 xml 중 선택된 xml 로딩
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		// 선택된 xml의 bean 사용
		
		System.out.println("ip : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		
		ctx.close();
	}
	

}
