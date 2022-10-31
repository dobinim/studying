package com.kim.ex0805;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String config = null;
		System.out.println("�ܼ�â�� �Է��ϼ���.");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		if(str.equals("dev")) {
			config = "dev";
		} else if (str.equals("run")) {
			config = "run";
		}

		scanner.close();
		
		
		// Java���� ������̼����� �����ϴ� AnnotationConfigApplicationContext�� �������!
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.register(ApplicationConfigDev.class, ApplicationConfigRun.class);
		// ������̼� ����� ��� �� load�� �ƴ϶� register(����Ŭ����1, ����Ŭ����2) ���
		// ����Ŭ���� �̸� �� �� ����ǥ�� �̷��� ���� �ʰ� ������.class�� ���
		
		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		
		System.out.println("===========================");
		System.out.println("ip : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		System.out.println("===========================");
	}	

}
