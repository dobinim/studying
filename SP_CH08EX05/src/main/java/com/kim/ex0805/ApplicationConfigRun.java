package com.kim.ex0805;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration	// 클래스에 어노테이션!
@Profile("run")	// run의 설정 어노테이션이란 뜻 = xml의 profile = "run" 역할
public class ApplicationConfigRun {
	@Bean
	public ServerInfo serverInfo() {
		ServerInfo info = new ServerInfo();
		info.setIpNum("213.186.229.29");
		info.setPortNum("80");
		
		return info;
	}
}
