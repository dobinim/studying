package com.kim.ch16Project1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) {
		try {
			new UDPClient().start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void start() throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket();
		InetAddress serverAddress = InetAddress.getByName("220.86.75.6");
		
		// 데이터가 저장될 공간으로 바이트 배열 생성
		byte[] msg = new byte[100];
		
		DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7777);
		DatagramPacket inPacket = new DatagramPacket(msg, msg.length);
	
		datagramSocket.send(outPacket);	//DatagramPacket을 전송한다.
		datagramSocket.receive(inPacket); // DatagramPacket을 수신한다.
		
		System.out.println("current server time : " + new String(inPacket.getData()));
	//  System.out.println("current server time : " + Arrays.toString(inPacket.getData()));
	//  → 하면 바이트배열 자체가 등장함.	
	// String 클래스에는 String(byte[] b)라는 생성자가 있는데, 이는 바이트 배열을 문자열로 변환하는 생성자이다.
		datagramSocket.close();
	}

}
