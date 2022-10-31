package com.kim.ch16Project1;

import java.net.URL;

public class MainClass02 {

	public static void main(String[] args) throws Exception {
		URL url = new URL("https://www.codechobo.com:8443/sample/" + "hello.html?referer=codechobo#index1");
		
		System.out.println("url.getAuthority() : " + url.getAuthority());
		// URL�� Authority�κ��� ��ȯ, www.codechobo.com:80(ȣ��Ʈ��� ��Ʈ��ȣ)
		// System.out.println("url.getContent() : " + url.getContent());
		// URL�� content �κ� ��ȯ
		System.out.println("url.getDefaultPort() : " + url.getDefaultPort()); // ��Ʈ�� �⺻�� (http�� 80, https�� 443)
		System.out.println("url.getPort() : " + url.getPort());	// �ش� ��Ʈ�� ��
		System.out.println("url.getFile() : " + url.getFile());	// ���ϸ� (��κ��� ��������)
		System.out.println("url.getHost() : " + url.getHost());	// ȣ��Ʈ �̸� (port ������)
		System.out.println("url.getPath() : " + url.getPath());	// ��κ��� ���ϱ���
		System.out.println("url.getProtocol() : " + url.getProtocol()); // �������ݸ� 
		System.out.println("url.getQuery() : " + url.getQuery());	// �����κ� (# ���� �� ������ ����)
		System.out.println("url.getRef() : " + url.getRef());	// �����κ� (# ����)
		System.out.println("url.getUserInfo() : " + url.getUserInfo());
		System.out.println("url.toExternalForm() : " + url.toExternalForm());	// URL ��ü�� ���ڿ��� ��ȯ
		System.out.println("url.toURI() : " + url.toURI());	//	URL�� URI�� ��ȯ
		// URI�� Uniform Resource Identifier�� ���ڷ� URL�� �����ϰ� �ִ�
		// URL�� ��ġ�� ��Ÿ���������� URI�� ��ġ�Ӹ� �ƴ϶� �ĺ� ��ȣ�μ��� ��ɵ� ������.
		
		
	}
}
