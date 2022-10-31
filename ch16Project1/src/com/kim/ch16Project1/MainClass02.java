package com.kim.ch16Project1;

import java.net.URL;

public class MainClass02 {

	public static void main(String[] args) throws Exception {
		URL url = new URL("https://www.codechobo.com:8443/sample/" + "hello.html?referer=codechobo#index1");
		
		System.out.println("url.getAuthority() : " + url.getAuthority());
		// URL의 Authority부분을 반환, www.codechobo.com:80(호스트명과 포트번호)
		// System.out.println("url.getContent() : " + url.getContent());
		// URL의 content 부분 반환
		System.out.println("url.getDefaultPort() : " + url.getDefaultPort()); // 포트의 기본값 (http는 80, https는 443)
		System.out.println("url.getPort() : " + url.getPort());	// 해당 포트의 값
		System.out.println("url.getFile() : " + url.getFile());	// 파일명 (경로부터 쿼리까지)
		System.out.println("url.getHost() : " + url.getHost());	// 호스트 이름 (port 전까지)
		System.out.println("url.getPath() : " + url.getPath());	// 경로부터 파일까지
		System.out.println("url.getProtocol() : " + url.getProtocol()); // 프로토콜명 
		System.out.println("url.getQuery() : " + url.getQuery());	// 쿼리부분 (# 으로 된 참조는 제외)
		System.out.println("url.getRef() : " + url.getRef());	// 참조부분 (# 이후)
		System.out.println("url.getUserInfo() : " + url.getUserInfo());
		System.out.println("url.toExternalForm() : " + url.toExternalForm());	// URL 객체를 문자열로 변환
		System.out.println("url.toURI() : " + url.toURI());	//	URL을 URI로 반환
		// URI는 Uniform Resource Identifier의 약자로 URL을 포함하고 있다
		// URL은 위치를 나타낼뿐이지만 URI는 위치뿐만 아니라 식별 부호로서의 기능도 가진다.
		
		
	}
}
