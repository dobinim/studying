package com.kim.ex0401;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
			// Java니까 MainClass 는 있어야하고, MainClass니까 public static void 있어야지!
	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		// xml에 설정된 것을 해석해서 객체를 생성함
		MyInfo myinfo = ctx.getBean("myInfo", MyInfo.class);
		myinfo.getInfo();

		ctx.close();	// ctx 닫아주기
	}

}
