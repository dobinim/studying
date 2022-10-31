package com.kim.ch13Project1;

import javax.swing.JOptionPane;

/* thread�� ����Ͽ� IO ���ŷ ���� */
public class MainClass05 {

	public static void main(String[] args) {
		Runnable r = new Thread05(); 	// Runnable ���� Ŭ������ thread Ȱ��
		Thread th = new Thread(r);
		
		th.start();
		
		/* ���ν������� ���� �κ� */
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���");
		System.out.println("�Է��Ͻ� ���� " + input + " �Դϴ�.");
		
	}

}

class Thread05 implements Runnable {
	@Override
	public void run() {
		for (int i = 10; i > 0 ; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
}