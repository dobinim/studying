package com.kim.ch13Project1;

import javax.swing.JOptionPane;	// GUI 처리 클래스로 대화창 처리

public class MainClass04 {

	public static void main(String[] args) {
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		// 대화창을 생성 (팝업창)
		System.out.println("입력하신 값은 " + input + " 입니다.");
		
		for(int i = 10 ; i > 0 ; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);	// 1000 밀리세컨드 동안 중지
			} catch (Exception e) {
				e.getMessage();
			}
		}

	}

}
