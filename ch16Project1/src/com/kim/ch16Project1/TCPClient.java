package com.kim.ch16Project1;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) throws Exception {
		// String serverIp = "127.0.0.1";	// LocalHost�� �ּ� (���� PC)
		String serverIp = "220.86.75.6";	// ����� pc 
		
		System.out.println("������ �������Դϴ�. ���� ip : " + serverIp);
		// ������ �����Ͽ� ���� ��û
		Socket socket = new Socket(serverIp, 7777);
		// ServerSocket���� �����ϴ� Socket ����
		
		// ������ �Է½�Ʈ���� ��´�.
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		// �������κ��� ���� �����͸� ����Ѵ�.
		System.out.println("�����κ��� ���� �޽��� : " + dis.readUTF());
		System.out.println("������ �����մϴ�.");
		
		// ��Ʈ���� ������ �ݴ´�.
		dis.close();
		socket.close();
		System.out.println("������ ����Ǿ����ϴ�.");
		
		

	}

}
