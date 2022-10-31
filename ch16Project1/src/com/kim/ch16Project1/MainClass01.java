package com.kim.ch16Project1;

import java.net.InetAddress;
import java.util.Arrays;

public class MainClass01 {

	public static void main(String[] args) {
		
		InetAddress ip = null;	// �� Ŭ������ ���ͳ� ��������(IP) �ּҸ� ó���ϴ� Ŭ����
		InetAddress[] ipArr = null;
		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName() : " + ip.getHostName());
			System.out.println("getHostAddress() : " + ip.getHostAddress());
			// ���ڷ� �� ip �ּҸ� ���ڿ��� ��ȯ
			System.out.println("toString() : " + ip.toString());
			// InetAddress Ŭ�������� �����ǵ� toString()���� ��ü ip�� ����ϸ� host name/���� �ּҷ� ��Ÿ��
			byte[] ipAddr = ip.getAddress();
			// �ּҸ� byte�� �ִ밪�� 127�� ������ -�� �ٲپ� byte�� ���� (127�� ���� �ּҰ�) -256
			System.out.println("getAddress() : " + Arrays.toString(ipAddr));
	
			String result = "";
			for (int i = 0; i < ipAddr.length ; i++) {
				result += (ipAddr[i] < 0? ipAddr[i] + 256 : ipAddr[i]) + ".";
			}
			
			System.out.println("getAddress() + 256 : " + result);
			System.out.println();
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			ip = InetAddress.getLocalHost(); 	// �� ��ǻ�͸� ��Ÿ���� InetAddress ��ü
			System.out.println("getHostName() : " + ip.getHostName());
			System.out.println("getHostAddress() : " + ip.getHostAddress());
			System.out.println();
					
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		try {
			ipArr = InetAddress.getAllByName("wwww.naver.com");	// host�� ������ �ִ� ��� InetAddress ��ü�� �迭�� ��ȯ
			for (int i = 0; i < ipArr.length ; i++) {
				System.out.println("ipArr[" + i + "] : " + ipArr[i]);
			}
			
		} catch (Exception e) {
			
		}
	}
}
