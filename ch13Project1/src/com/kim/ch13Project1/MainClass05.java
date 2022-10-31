package com.kim.ch13Project1;

import javax.swing.JOptionPane;

/* thread를 사용하여 IO 블록킹 예방 */
public class MainClass05 {

	public static void main(String[] args) {
		Runnable r = new Thread05(); 	// Runnable 구현 클래스의 thread 활용
		Thread th = new Thread(r);
		
		th.start();
		
		/* 메인스레드의 실행 부분 */
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
		System.out.println("입력하신 값은 " + input + " 입니다.");
		
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