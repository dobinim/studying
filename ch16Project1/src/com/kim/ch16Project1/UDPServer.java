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
		DatagramSocket socket1 = new DatagramSocket(7777);	// 예외처리가 필요한 생성자
		DatagramPacket inPacket, outPacket; 	// 송, 수신물 패킷 (데이터를 수용하는 패킷)
		
		byte[] inMsg = new byte[10];
		byte[] outMsg;
		
		while (true) {
			// 데이터를 수신하기 위한 패킷을 생성한다. 수신용 패킷 → inPacket
			inPacket = new DatagramPacket(inMsg, inMsg.length);
						// 바이트배열 형태로 된 메시지를 크기를 지정해 패킷으로 저장한다.
			// 수신한 데이터를 2번째 매개변수로, 지정한 크기의 바이트 배열에 저장하는 수신 패킷 생성
			socket1.receive(inPacket); // 패킷을 통해 데이터를 수신(receive) 한다.
			// 수신한 패킷으로부터 client의 ip주소와 port를 얻는다.
			InetAddress address = inPacket.getAddress();
			int port = inPacket.getPort();
			
			// 서버의 현재 시간을 시분초 형태([hh:mm:ss])로 변환한다.
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String time = sdf.format(new Date());
			outMsg = time.getBytes(); // time을 바이트배열로 변환한다.
			
			// 패킷을 생성해 client에게 전송(send)한다.
			outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
			// address 와 port가 있는 생성자는 송신용 패킷 객체
			socket1.send(outPacket);	// 송신패킷을 address의 port로 보낸다.
		}
	}
}
