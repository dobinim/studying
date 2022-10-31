package com.kim.ch13Project1;

import javax.swing.JOptionPane;

public class MainClass10 {

	public static void main(String[] args) {
		Thread10 th = new Thread10();
		th.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + " 입니다.");
		th.interrupt();		// interrupt 상태가 true로 변경됨
		System.out.println("isInterrupted() : " + th.isInterrupted()); // true
		// interrupted 상태가 true 가 되면 중단중인 스레드가 실행 가능 상태로 됨
	}
}


class Thread10 extends Thread {
	@Override
	public void run() {
		int i = 10;
		
		while (i!=0 && !isInterrupted()) {
			// i가 0이 아니고 interrupted 상태가 아니라면
			System.out.println(i--);
			for(long x = 0; x < 2500000000L; x++);
		}
		
		System.out.println("카운트가 종료되었습니다.");
	}
}