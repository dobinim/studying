package com.kim.ex0801;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

// ConfigurableEnvironment env 객체가 아닌 Environment env 객체를 사용
// 단, MutablePropertySources에서 값을 저장한 뒤에 가능
public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean {
	private Environment env;
	private String adminId;
	private String adminPw;


public AdminConnection() {
		super();
	}

	public AdminConnection(Environment env, String adminId, String adminPw) {
		super();
		this.env = env;
		this.adminId = adminId;
		this.adminPw = adminPw;
	}
	
	// 추상메서드 정의 (순서대로 진행됨!)
	@Override
	public void setEnvironment(Environment env) {
		// EnvironmentAware 인터페이스의 추상메서드로, 실행 시 호출되는 callback 메서드 (객체 생성 시)
		System.out.println("setEnvironment() 실행");
		setEnv(env);	// Environment 객체를 얻어 env에 저장
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// InitializingBean 인터페이스의 추상메서드로, 스프링 컨테이너 객체 초기화 이후에 실행
		// 이때 속성값을 설정해줌
		System.out.println("afterPropertiesSet() 실행");
		setAdminId(env.getProperty("admin.id"));	
		// Environment env에 있는 getProperty("속성명") 메서드로 값을 반환    
		setAdminPw(env.getProperty("admin.pw"));
	}
	
	@Override
	public void destroy() throws Exception {
		// DisposableBean의 추상메서드 
		System.out.println("destroy() 실행");

	}	
	
	// getter, setter 
	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	
}