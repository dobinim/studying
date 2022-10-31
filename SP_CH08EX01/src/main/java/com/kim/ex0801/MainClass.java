package com.kim.ex0801;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = 
				new GenericXmlApplicationContext();
		/* ConfigurableApplicationContext : 
		인터페이스. 환경변수 설정 시 사용하는 스프링 컨테이너 객체로 
		환경변수 구성용 객체를 얻어내는 메서드를 제공. 		*/
		ConfigurableEnvironment env = ctx.getEnvironment();
		// 환경 변수 구성 객체를 얻어냄
		
		/* 순서 : ConfigurableApplicationContext 객체 생성 후 → 그 안의 메서드 (getEnvironment())를 
		 		 이용해 ConfigurableEnvironment 형태의 환경 변수 구성 객체(env)를 얻어냄            */
		
		MutablePropertySources propertySources = env.getPropertySources();
		// MutablePropertySources : 속성을 조작하는 인터페이스 객체. 
		
		try {				
			// bean을 통하지 않고 (Bean 클래스의 get메서드 없이) 바로 .properties에 있는 속성을 가져옴
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
							// ResourcePropertySource : 속성 정보를 가진 자원을 처리하는 클래스
							// admin.properties라는 속성용 파일을 객체화해 
							// propertySources를 마지막에 추가 (addLast)
									
			System.out.println(env.getProperty("admin.id"));
							// ConfigurableEnvironment env 객체의 getProperty()메서드를 사용 → 속성값 반환
			System.out.println(env.getProperty("admin.pw"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		/* xml 사용을 위해 형변환
		→ Xml 에 Environment 객체를 사용하는 bean을 만들고 
		EnvironmentAware, InitializingBean, DisposableBean을 구현한 클래스에서 
		Environment 객체를 얻어내고 InitializingBean의 메서드에서 변수값 설정해둠 */
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		/* ConfigurableApplicationContext 객체인 ctx를 GenericXmlApplicationContext 객체로 형변환 
			→ gCtx 객체에 저장 */
		gCtx.load("applicationCTX.xml");
		gCtx.refresh();		// 초기화
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
		System.out.println("admin ID : " + adminConnection.getAdminId());
		System.out.println("admin PW : " + adminConnection.getAdminPw());
		
		gCtx.close();
		ctx.close();
		
		
	}	// main메서드 끝

}
