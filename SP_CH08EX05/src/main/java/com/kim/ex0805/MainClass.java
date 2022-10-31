package com.kim.ex0805;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String config = null;
		System.out.println("콘솔창에 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		if(str.equals("dev")) {
			config = "dev";
		} else if (str.equals("run")) {
			config = "run";
		}

		scanner.close();
		
		
		// Java에서 어노테이션으로 설정하니 AnnotationConfigApplicationContext를 써줘야지!
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.register(ApplicationConfigDev.class, ApplicationConfigRun.class);
		// 어노테이션 사용할 경우 → load가 아니라 register(설정클래스1, 설정클래스2) 사용
		// 설정클래스 이름 쓸 때 따옴표나 이런거 쓰지 않고 ㅇㅇㅇ.class로 사용
		
		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		
		System.out.println("===========================");
		System.out.println("ip : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		System.out.println("===========================");
	}	

}
