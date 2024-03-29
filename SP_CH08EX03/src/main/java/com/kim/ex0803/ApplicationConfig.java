package com.kim.ex0803;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationConfig {
	/* properties 파일을 사용하기 위해서는 @Value("${properties 파일의 key값}") 어노테이션을 사용하고
	 	그 밑에 그 값을 저장할 멤버변수를 선언한다. */
	
	@Value("${admin.id}")
	private String adminId;
	
	@Value("${admin.pw}")
	private String adminPw;
	
	@Value("${sub_admin.id}")
	private String sub_adminId;
	
	@Value("${sub_admin.pw}")
	private String sub_adminPw;
	
	
	// properties 파일의 위치를 등록하여 @Value를 이용해 properties 의 속성을 멤버 변수에 설정해줌 
	// xml에서 <context:property-placeholder location = "classpath:admin.properties, classpath:sub_admin.properties"/> 역할
	// properties 파일들을 등록해주는 메서드로 callback (자동 호출)
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
				// PropertySourcesPlaceholder = 속성이 저장되어 있는 구성 객체 
		PropertySourcesPlaceholderConfigurer configurer = 
				new PropertySourcesPlaceholderConfigurer();
		Resource[] locations = new Resource[2]; 	
		// properties 파일의 개수만큼 크기를 갖는 배열을 생성 → 여기선 admin, subadmin 두개니까 크기가 2

		locations[0] = new ClassPathResource("admin.properties");
		locations[1] = new ClassPathResource("sub_admin.properties");
		
		configurer.setLocations(locations);
		return configurer;
	}
	
	@Bean
	// @Value로 만들어진 속성값을 Bean 이름이 adminConfig인 AdminConnection 객체에 설정
	public AdminConnection adminConfig() {
		AdminConnection adminConnection = new AdminConnection();
		adminConnection.setAdminId(adminId);
		adminConnection.setAdminPw(adminPw);
		adminConnection.setSub_adminId(sub_adminId);
		adminConnection.setSub_adminPw(sub_adminPw);
		
		return adminConnection;
	}
}
