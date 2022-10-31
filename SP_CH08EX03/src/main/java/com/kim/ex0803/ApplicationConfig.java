package com.kim.ex0803;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationConfig {
	/* properties ������ ����ϱ� ���ؼ��� @Value("${properties ������ key��}") ������̼��� ����ϰ�
	 	�� �ؿ� �� ���� ������ ��������� �����Ѵ�. */
	
	@Value("${admin.id}")
	private String adminId;
	
	@Value("${admin.pw}")
	private String adminPw;
	
	@Value("${sub_admin.id}")
	private String sub_adminId;
	
	@Value("${sub_admin.pw}")
	private String sub_adminPw;
	
	
	// properties ������ ��ġ�� ����Ͽ� @Value�� �̿��� properties �� �Ӽ��� ��� ������ �������� 
	// xml���� <context:property-placeholder location = "classpath:admin.properties, classpath:sub_admin.properties"/> ����
	// properties ���ϵ��� ������ִ� �޼���� callback (�ڵ� ȣ��)
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
				// PropertySourcesPlaceholder = �Ӽ��� ����Ǿ� �ִ� ���� ��ü 
		PropertySourcesPlaceholderConfigurer configurer = 
				new PropertySourcesPlaceholderConfigurer();
		Resource[] locations = new Resource[2]; 	
		// properties ������ ������ŭ ũ�⸦ ���� �迭�� ���� �� ���⼱ admin, subadmin �ΰ��ϱ� ũ�Ⱑ 2

		locations[0] = new ClassPathResource("admin.properties");
		locations[1] = new ClassPathResource("sub_admin.properties");
		
		configurer.setLocations(locations);
		return configurer;
	}
	
	@Bean
	// @Value�� ������� �Ӽ����� Bean �̸��� adminConfig�� AdminConnection ��ü�� ����
	public AdminConnection adminConfig() {
		AdminConnection adminConnection = new AdminConnection();
		adminConnection.setAdminId(adminId);
		adminConnection.setAdminPw(adminPw);
		adminConnection.setSub_adminId(sub_adminId);
		adminConnection.setSub_adminPw(sub_adminPw);
		
		return adminConnection;
	}
}
