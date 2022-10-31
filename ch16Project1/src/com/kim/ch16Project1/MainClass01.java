package com.kim.ch16Project1;

import java.net.InetAddress;
import java.util.Arrays;

public class MainClass01 {

	public static void main(String[] args) {
		
		InetAddress ip = null;	// 이 클래스는 인터넷 프로토콜(IP) 주소를 처리하는 클래스
		InetAddress[] ipArr = null;
		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName() : " + ip.getHostName());
			System.out.println("getHostAddress() : " + ip.getHostAddress());
			// 숫자로 된 ip 주소를 문자열로 변환
			System.out.println("toString() : " + ip.toString());
			// InetAddress 클래스에서 재정의된 toString()으로 객체 ip를 출력하면 host name/숫자 주소로 나타남
			byte[] ipAddr = ip.getAddress();
			// 주소를 byte의 최대값인 127을 넘으면 -로 바꾸어 byte로 변경 (127을 넘은 주소값) -256
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
			ip = InetAddress.getLocalHost(); 	// 내 컴퓨터를 나타내는 InetAddress 객체
			System.out.println("getHostName() : " + ip.getHostName());
			System.out.println("getHostAddress() : " + ip.getHostAddress());
			System.out.println();
					
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		try {
			ipArr = InetAddress.getAllByName("wwww.naver.com");	// host가 가지고 있는 모든 InetAddress 객체를 배열로 반환
			for (int i = 0; i < ipArr.length ; i++) {
				System.out.println("ipArr[" + i + "] : " + ipArr[i]);
			}
			
		} catch (Exception e) {
			
		}
	}
}
