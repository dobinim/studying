package com.kim.ch16Project1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPServer {

	public static void main(String[] args) {
		try {
			System.out.println("UDP Server Start");
			new UDPServer().start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void start() throws IOException {
		DatagramSocket socket1 = new DatagramSocket(7777);	// ����ó���� �ʿ��� ������
		DatagramPacket inPacket, outPacket; 	// ��, ���Ź� ��Ŷ (�����͸� �����ϴ� ��Ŷ)
		
		byte[] inMsg = new byte[10];
		byte[] outMsg;
		
		while (true) {
			// �����͸� �����ϱ� ���� ��Ŷ�� �����Ѵ�. ���ſ� ��Ŷ �� inPacket
			inPacket = new DatagramPacket(inMsg, inMsg.length);
						// ����Ʈ�迭 ���·� �� �޽����� ũ�⸦ ������ ��Ŷ���� �����Ѵ�.
			// ������ �����͸� 2��° �Ű�������, ������ ũ���� ����Ʈ �迭�� �����ϴ� ���� ��Ŷ ����
			socket1.receive(inPacket); // ��Ŷ�� ���� �����͸� ����(receive) �Ѵ�.
			// ������ ��Ŷ���κ��� client�� ip�ּҿ� port�� ��´�.
			InetAddress address = inPacket.getAddress();
			int port = inPacket.getPort();
			
			// ������ ���� �ð��� �ú��� ����([hh:mm:ss])�� ��ȯ�Ѵ�.
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String time = sdf.format(new Date());
			outMsg = time.getBytes(); // time�� ����Ʈ�迭�� ��ȯ�Ѵ�.
			
			// ��Ŷ�� ������ client���� ����(send)�Ѵ�.
			outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
			// address �� port�� �ִ� �����ڴ� �۽ſ� ��Ŷ ��ü
			socket1.send(outPacket);	// �۽���Ŷ�� address�� port�� ������.
		}
	}
}
