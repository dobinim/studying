package com.kim.ex0301;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*  
		 - ���� Java ���
		 MyCalculator myCalculator = new MyCalculator();
		 �� MyCalculator ��ü ����
		 myCalculator.setCalculator(new MyCalculator()); 
		 			�� setCalculator : ��ü�� �޾� calculator�� ����
		 myCalculator.setFirstNum(10);
		 			�� MyCalculator�� FirstNum���� 10 ����
		 myCalculator.setSecondNum(2);
		 			�� MyCalculator�� SecondNum���� 2 ����
		 myCalculator.add();
		 			�� add ����
		 */

		
									// Spring ��� : ������ ���� ����
		
		// 1. ������ ���������� ��ġ�� ���ڿ��� ����
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		/* AbstractApplicationContext 
		 - �߻� Ŭ����. IOC �����̳� ���� ����(applicationCTX.xml)�� ������ �ε��� ��ü�� �����ϴ� �������̽� 
		 - ������ �����̳� �� ������ ��(Bean)�� �߰� ����� �ο�
		 * GenericXmlApplicationContext()
		 - ���� �߻� Ŭ������ ������ Ŭ����. ���Ե� ��ü�� ���� 							  	  	    */
		MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
										/* getBean("beanŬ������ id", beanŬ����) */
		myCalculator.add();
		
	}

}


/*
	������ IOC �����̳��� ���� ����(xml) �� src/main/resources�� ����
 	AbstractApplicationContext ��ü�� GenericXmlApplicationContext Ŭ������ ����
 		�� �̶�, �Ķ���ͷ� �ش� ���� ����(xml)�� ��θ� ���
 	������ �����̳� ��ü�� ���� �� (���⼱ MyCalculator) getBean("bean�̸�", Ŭ�������ϸ�)���� ��ü ���Թ���  
 */