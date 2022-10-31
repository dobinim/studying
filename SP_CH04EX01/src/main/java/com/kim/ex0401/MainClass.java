package com.kim.ex0401;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
			// Java�ϱ� MainClass �� �־���ϰ�, MainClass�ϱ� public static void �־����!
	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		// xml�� ������ ���� �ؼ��ؼ� ��ü�� ������
		MyInfo myinfo = ctx.getBean("myInfo", MyInfo.class);
		myinfo.getInfo();

		ctx.close();	// ctx �ݾ��ֱ�
	}

}
