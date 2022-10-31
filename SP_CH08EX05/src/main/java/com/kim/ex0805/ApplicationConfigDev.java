package com.kim.ex0805;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration	// Ŭ������ ������̼�!
@Profile("dev")	// dev�� ���� ������̼��̶� �� = xml�� profile = "dev" ����
public class ApplicationConfigDev {

	@Bean
	public ServerInfo serverInfo() {
		ServerInfo info = new ServerInfo();
		info.setIpNum("localhost");
		info.setPortNum("8181");
		
		return info;
	
	}	// serverInfo�� ��
		
} // �� Ŭ������ �� 
