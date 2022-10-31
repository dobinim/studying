package com.kim.ex0804;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String config = null;
		System.out.println("�ܼ�â�� �Է����ּ���.");
		Scanner scanner = new Scanner(System.in);	// Ű���� �Է�ó�� ��ü
		String str = scanner.next(); // �Էµ� ��. �Է� �� ���� �� 
		if (str.equals("dev")) { 
			config = "dev";
		} else if (str.equals("run")) {
			config = "run";
		}
		
		scanner.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		// getEnvironment()�� ConfigurableEnvironment ��ü�� ��ȯ�ϰ�,
		// setActiveProfiles(config)�� xml�� profile�� config�� xml ����
		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
		// 2���� xml �� ���õ� xml �ε�
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		// ���õ� xml�� bean ���
		
		System.out.println("ip : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		
		ctx.close();
	}
	

}
