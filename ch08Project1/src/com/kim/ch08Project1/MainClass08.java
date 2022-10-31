package com.kim.ch08Project1;

import java.io.File;

public class MainClass08 {
							// args = String ���� �̷��� �迭[]
	public static void main(String[] args) {
		try {
			// main �޼����� �Ű������� arg ��� ��, run configurations��
			// �ڹ� ������ �� ���� ���� �־���� �Ѵ�
			File f = createFile(args[0]); // args[0]�� ���� �̸����� ��ü�� �� ����
			// File Ŭ������ file ó���� ���� �Ӽ�, �޼��带 ������ �ִ� Ŭ���� 
			System.out.println(f.getName() + "������ ���������� �����Ǿ����ϴ�.");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "�ٽ� �Է��� �ֽñ� �ٶ��ϴ�.");
		}
		System.out.println("main �޼����� ������");
	}
	
	static File createFile(String fileName) throws Exception {
		// Exception ����ó���� ȣ���� main �޼���� ������
		if(fileName==null || fileName.equals("")) {
			throw new Exception ("���� �̸��� ��ȿ���� �ʽ��ϴ�.");
			// �޽����� '���� �̸��� ��ȿ���� �ʽ��ϴ�' ���ܸ� ����� ������
		}
		File f = new File(fileName);	// ���� ��ü ����, fileName�� ���� ���ϵ��� ó���ϴ� ��ü(�ν��Ͻ�)
		f.createNewFile();				// ���� ������ ���� (���� ���� ������ ��ũ�� ����, ���� �� true)
		return f;						// ������ ��ü�� ���� ��ȯ
	}
	

}