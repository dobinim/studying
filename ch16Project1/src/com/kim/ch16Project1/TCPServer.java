package com.kim.ch16Project1;
/* Server�� ��ǻ�ͷ� ������ �� ��! Client�� ������!*/
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serversocket = null;
		// ServerSocket �� TCP ��ſ��� ���� ó���� �ϴ� Ŭ����
		try { 
			serversocket = new ServerSocket(7777);
			// port 7777�� ����ϴ� serversocket
			System.out.println(getTime() + " ������ �غ�Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				System.out.println(getTime() + " ���� ��û�� ��ٸ��ϴ�.");
				// ���� ������ Ŭ���̾�Ʈ�� �����û�� �� ������ ������ ���߰� ��� ��ٸ���.
				// Ŭ���̾�Ʈ�� �����û�� ���� Ŭ���̾�Ʈ ���ϰ� ����� ���ο� ������ �����Ѵ�.
				Socket socket = serversocket.accept();
				// ���� ����ϴٰ� ������ �Ͼ�� socket ��ü�� �����Ͽ� ��ȯ (��û ������ ���� ǥ��)
				System.out.println(getTime() + socket.getInetAddress() + " �κ��� ���� ��û�� ���Խ��ϴ�.");
				// ������ ��� ��Ʈ���� ��´�.
				OutputStream out = socket.getOutputStream();	// socket�� ����Ǵ� OutputStream ��ü ����
				DataOutputStream dos = new DataOutputStream(out);	// data�� �⺻��ó�� ó���ϴ� ���� ��Ʈ��
				// ���� ����(remote socket)�� �����͸� ������.
				dos.writeUTF("[Notice] Test Message1 from Server."); // UTF ���ڿ��η� write�ϴ� �޼���
				// ���� ���α׷������� ��� ��Ʈ���� �ۼ��ϸ� �������� �����Ѵ�.
				// ��Ʈ���� ������ �ݾ��ش�.
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
