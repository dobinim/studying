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
		�������̽�. ȯ�溯�� ���� �� ����ϴ� ������ �����̳� ��ü�� 
		ȯ�溯�� ������ ��ü�� ���� �޼��带 ����. 		*/
		ConfigurableEnvironment env = ctx.getEnvironment();
		// ȯ�� ���� ���� ��ü�� ��
		
		/* ���� : ConfigurableApplicationContext ��ü ���� �� �� �� ���� �޼��� (getEnvironment())�� 
		 		 �̿��� ConfigurableEnvironment ������ ȯ�� ���� ���� ��ü(env)�� ��            */
		
		MutablePropertySources propertySources = env.getPropertySources();
		// MutablePropertySources : �Ӽ��� �����ϴ� �������̽� ��ü. 
		
		try {				
			// bean�� ������ �ʰ� (Bean Ŭ������ get�޼��� ����) �ٷ� .properties�� �ִ� �Ӽ��� ������
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
							// ResourcePropertySource : �Ӽ� ������ ���� �ڿ��� ó���ϴ� Ŭ����
							// admin.properties��� �Ӽ��� ������ ��üȭ�� 
							// propertySources�� �������� �߰� (addLast)
									
			System.out.println(env.getProperty("admin.id"));
							// ConfigurableEnvironment env ��ü�� getProperty()�޼��带 ��� �� �Ӽ��� ��ȯ
			System.out.println(env.getProperty("admin.pw"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		/* xml ����� ���� ����ȯ
		�� Xml �� Environment ��ü�� ����ϴ� bean�� ����� 
		EnvironmentAware, InitializingBean, DisposableBean�� ������ Ŭ�������� 
		Environment ��ü�� ���� InitializingBean�� �޼��忡�� ������ �����ص� */
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		/* ConfigurableApplicationContext ��ü�� ctx�� GenericXmlApplicationContext ��ü�� ����ȯ 
			�� gCtx ��ü�� ���� */
		gCtx.load("applicationCTX.xml");
		gCtx.refresh();		// �ʱ�ȭ
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
		System.out.println("admin ID : " + adminConnection.getAdminId());
		System.out.println("admin PW : " + adminConnection.getAdminPw());
		
		gCtx.close();
		ctx.close();
		
		
	}	// main�޼��� ��

}
