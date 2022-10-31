package com.kim.ch16Project1;

import java.net.URL;
import java.net.URLConnection;

public class MainClass03 {

	public static void main(String[] args) {
		
		String address = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_elements";
		try {
			URL url = new URL(address);
			URLConnection conn = url.openConnection();
			/* 
			System.out.println("conn.toString() : " + conn);
			System.out.println("getAllowUserInteraction() : " + conn.getAllowUserInteraction());
			System.out.println("\togetConnectTimeout() : " + conn.getConnectTimeout());	// timeout�� �⺻�� 0���� �����Ǿ� ����
			System.out.println("getContent() : " + conn.getContent());
			System.out.println("getContentEncoding() : " + conn.getContentEncoding()); 
			*/
			System.out.println("getURL() : " + conn.getURL());
			System.out.println("getUseCaches() : " + conn.getUseCaches());
			// cache �޸� ��� ���� �� true/false
			System.out.println("getContentType() : " + conn.getContentType());	// �ڿ��� ����(������)
			System.out.println("\tgetDate() : " + conn.getDate());	// posixŸ�� (�и�������� ����ð� / 1970.1.1.0)
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
