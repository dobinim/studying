package com.kim.ch13Project1;

public class MainClass12 {

	public static void main(String[] args) {
		Thread th1 = new Thread(new Thread12());
		Thread th2 = new Thread(new Thread12());
		
		th1.start();
		th2.start();

	}

}

class Account {
	private int balance = 1000; 	// private로 해야 동기화가 의미있다. balance = 잔액
	
	public int getBalance() { 	// 잔액 반환
		return balance; 
	}
	
	public synchronized void withdraw(int money) {	// 중복 출금을 막기 위해 synchronized 사용
		if(balance >= money) {		// money는 지출액
			try {
				Thread.sleep(1000);		// 1초 정도 여유를 둠.
			} catch (Exception e) {
				e.getMessage();
			}
			balance -= money;
		}
	}
}

class Thread12 implements Runnable {
	Account acc = new Account();
	@Override
	public void run() {
		while(acc.getBalance() > 0) {
		int money = (int)(Math.random() * 3 + 1) * 100;
		System.out.println("money : " + money);
		acc.withdraw(money);	// thread별로 withdraw()하나 synchronized이므로 한 번에 하나의 thread만 처리
		System.out.println("balance : " + acc.getBalance());
		}
	}
}