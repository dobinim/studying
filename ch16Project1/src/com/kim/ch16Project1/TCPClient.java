package com.kim.ch16Project1;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) throws Exception {
		// String serverIp = "127.0.0.1";	// LocalHost의 주소 (본인 PC)
		String serverIp = "220.86.75.6";	// 강사님 pc 
		
		System.out.println("서버에 연결중입니다. 서버 ip : " + serverIp);
		// 소켓을 생성하여 연결 요청
		Socket socket = new Socket(serverIp, 7777);
		// ServerSocket으로 연결하는 Socket 생성
		
		// 소켓의 입력스트림을 얻는다.
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		// 소켓으로부터 받은 데이터를 출력한다.
		System.out.println("서버로부터 받은 메시지 : " + dis.readUTF());
		System.out.println("연결을 종료합니다.");
		
		// 스트림과 소켓을 닫는다.
		dis.close();
		socket.close();
		System.out.println("연결이 종료되었습니다.");
		
		

	}

}
