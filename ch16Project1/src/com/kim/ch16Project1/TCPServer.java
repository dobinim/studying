package com.kim.ch16Project1;
/* Server는 컴퓨터로 돌리지 말 것! Client만 돌릴것!*/
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serversocket = null;
		// ServerSocket → TCP 통신에서 연결 처리를 하는 클래스
		try { 
			serversocket = new ServerSocket(7777);
			// port 7777을 사용하는 serversocket
			System.out.println(getTime() + " 서버가 준비되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				System.out.println(getTime() + " 연결 요청을 기다립니다.");
				// 서버 소켓은 클라이언트의 연결요청이 뜰 때까지 실행을 멈추고 계속 기다린다.
				// 클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
				Socket socket = serversocket.accept();
				// 접속 대기하다가 접속이 일어나면 socket 객체를 생성하여 반환 (요청 소켓의 정보 표현)
				System.out.println(getTime() + socket.getInetAddress() + " 로부터 연결 요청이 들어왔습니다.");
				// 소켓의 출력 스트림을 얻는다.
				OutputStream out = socket.getOutputStream();	// socket과 연결되는 OutputStream 객체 생성
				DataOutputStream dos = new DataOutputStream(out);	// data를 기본형처럼 처리하는 보조 스트림
				// 원격 소켓(remote socket)에 데이터를 보낸다.
				dos.writeUTF("[Notice] Test Message1 from Server."); // UTF 문자열로로 write하는 메서드
				// 소켓 프로그램에서는 출력 스트림에 작성하면 상대방으로 전송한다.
				// 스트림과 소켓을 닫아준다.
				dos.close();
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
	
}
