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
		
		// �����Ͱ� ����� �������� ����Ʈ �迭 ����
		byte[] msg = new byte[100];
		
		DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7777);
		DatagramPacket inPacket = new DatagramPacket(msg, msg.length);
	
		datagramSocket.send(outPacket);	//DatagramPacket�� �����Ѵ�.
		datagramSocket.receive(inPacket); // DatagramPacket�� �����Ѵ�.
		
		System.out.println("current server time : " + new String(inPacket.getData()));
	//  System.out.println("current server time : " + Arrays.toString(inPacket.getData()));
	//  �� �ϸ� ����Ʈ�迭 ��ü�� ������.	
	// String Ŭ�������� String(byte[] b)��� �����ڰ� �ִµ�, �̴� ����Ʈ �迭�� ���ڿ��� ��ȯ�ϴ� �������̴�.
		datagramSocket.close();
	}

}
