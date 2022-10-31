package com.kim.ex0805;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration	// 클래스에 어노테이션!
@Profile("dev")	// dev의 설정 어노테이션이란 뜻 = xml의 profile = "dev" 역할
public class ApplicationConfigDev {

	@Bean
	public ServerInfo serverInfo() {
		ServerInfo info = new ServerInfo();
		info.setIpNum("localhost");
		info.setPortNum("8181");
		
		return info;
	
	}	// serverInfo의 끝
		
} // 이 클래스의 끝 
