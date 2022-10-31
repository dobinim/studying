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
			System.out.println("\togetConnectTimeout() : " + conn.getConnectTimeout());	// timeout이 기본값 0으로 설정되어 있음
			System.out.println("getContent() : " + conn.getContent());
			System.out.println("getContentEncoding() : " + conn.getContentEncoding()); 
			*/
			System.out.println("getURL() : " + conn.getURL());
			System.out.println("getUseCaches() : " + conn.getUseCaches());
			// cache 메모리 사용 여부 → true/false
			System.out.println("getContentType() : " + conn.getContentType());	// 자원의 형태(웹문서)
			System.out.println("\tgetDate() : " + conn.getDate());	// posix타임 (밀리세컨드로 현재시간 / 1970.1.1.0)
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
