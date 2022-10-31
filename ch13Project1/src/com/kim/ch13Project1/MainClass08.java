package com.kim.ch13Project1;

public class MainClass08 implements Runnable {
	
	static boolean autoSave = false;

	public static void main(String[] args) {
		Thread t = new Thread(new MainClass08());
		// �̰� �� �ٷ� Ǯ��� ��
		// Runnable r = new MainClass08();
		// Thread t = new Thread(r);
		t.setDaemon(true); 	// ������ t�� ���� ������ daemon���� ��
		
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
		System.out.println("�۾� ������ �ڵ� ����Ǿ����ϴ�.");
	}
}
