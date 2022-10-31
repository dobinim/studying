package com.kim.ch08Project1;

public class MainClass10 {

	public static void main(String[] args) {
		 try {
			 startInstall();	// ���α׷� ��ġ�� �ʿ��� �غ�
			 copyFiles();		// ���� ����
		 } catch (SpaceException e) {
			 System.out.println("���� �޽��� : " + e.getMessage());
			 e.printStackTrace();
			 System.out.println("������ Ȯ���� �Ŀ� �ٽ� ��ġ�Ͻñ� �ٶ��ϴ�.");
		 } catch (MemoryException me) {
			 System.out.println("���� �޽��� : " + me.getMessage());
			 me.printStackTrace();
			 System.gc();		// Garbage Collection�� ������ �޸𸮸� �ø���
			 System.out.println("��ġ�� �ٽ� �õ��ϼ���.");
		 } finally {
			 deleteTempFiles();	// ���α׷� ��ġ�� ���� �ӽ����� ����
		 } // try-catch-finally �� ��
	}	// main ��

	static void startInstall() throws SpaceException, MemoryException {
		// ���� �߻� �� �����ڰ� ���� SpaceExcetion, MemoryException�� main �޼��忡�� ó���ϰ� ��
		if(!enoughSpace()) {
			throw new SpaceException("��ġ�� ������ �����մϴ�.");}
		if(!enoughMemory()) {
			throw new MemoryException("�޸𸮰� �����մϴ�.");}
		// �����ڰ� ���� ���ܸ� �߻����� ������
	}

	static void deleteTempFiles() {	}

	static void copyFiles() { }
	
	static boolean enoughSpace() {
		return false;
	}
	
	static boolean enoughMemory() {
		return true;
	}
}	// exception Ŭ������ ��


//JDK�� ���� ó�� Ŭ������ ����ϴ� ������ ���� ���� ó�� Ŭ����
class SpaceException extends Exception {
	SpaceException(String msg) {
		super(msg); 	// ���� ������ �޽����� ���� ���� �ν��Ͻ��� ����
	}
}
//JDK�� ���� ó�� Ŭ������ ����ϴ� ������ ���� ���� ó�� Ŭ���� 
class MemoryException extends Exception {
	MemoryException(String msg) {
		super(msg);
	}
}