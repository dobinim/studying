package com.kim.ch13Project1;

import javax.swing.JOptionPane;	// GUI ó�� Ŭ������ ��ȭâ ó��

public class MainClass04 {

	public static void main(String[] args) {
		
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���.");
		// ��ȭâ�� ���� (�˾�â)
		System.out.println("�Է��Ͻ� ���� " + input + " �Դϴ�.");
		
		for(int i = 10 ; i > 0 ; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);	// 1000 �и������� ���� ����
			} catch (Exception e) {
				e.getMessage();
			}
		}

	}

}
