package com.kim.ch13Project1;

public class MainClass08 implements Runnable {
	
	static boolean autoSave = false;

	public static void main(String[] args) {
		Thread t = new Thread(new MainClass08());
		// 이걸 두 줄로 풀어쓰면 ↓
		// Runnable r = new MainClass08();
		// Thread t = new Thread(r);
		t.setDaemon(true); 	// 스레드 t를 보조 스레드 daemon으로 함
		
		t.start();
		
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.getMessage();
			} 
			System.out.println(i);
			
			if (i==5)
				autoSave = true;
		}
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3 * 1000);
			} catch (Exception e) {
				e.getMessage();
			}
			
			if(autoSave)
				autoSave();
		}
	}
	
	public void autoSave() {
		System.out.println("작업 파일이 자동 저장되었습니다.");
	}
}
