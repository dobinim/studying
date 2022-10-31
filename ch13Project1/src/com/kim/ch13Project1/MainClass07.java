package com.kim.ch13Project1;

public class MainClass07 {
// ThreadGroup
// ThreadGroup 객체를 만들고 
	
	public static void main(String[] args) {
		ThreadGroup myGroup = new ThreadGroup("myGroup");
		// ThreadGroup을 생성자를 이용해 만듬
		WorkThread workThreadA = new WorkThread(myGroup, "WorkThreadA");
		// workThreadA 스레드는 스레드그룹이 myGroup이고, 스레드 이름이 workThreadA
		WorkThread workThreadB = new WorkThread(myGroup, "WorkThreadB");
		workThreadA.start();
		workThreadB.start();
		
		System.out.println(" [Main 스레드 그룹의 list() 메서드 출력 내용]");
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		// 현재 스레드 main스레드의 스레드그룹을 얻어냄 - 리스트 메서드로!
		mainGroup.list(); // 스레드그룹의 정보를 출력하는 메서드로,
		// 메인 메서드의 스레드 그룹은 자식인 myGroup을 포함한다 
		System.out.println();
		
		myGroup.list();		// myGroup자신만 출력
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}
		
		System.out.println("[MyGroup 스레드 그룹의 interrupt()메서드 호출]");
		myGroup.interrupt();	// myGroup에 속한 스레드들의 중단을 해제 (예외 발생 → sleep 중단)	
		
	}

}


class WorkThread extends Thread {
	public WorkThread (ThreadGroup threadGroup, String threadName) {
		// 생성자
		super (threadGroup, threadName); //thread 생성자
	}

	@Override
	public void run() {
		while(true) {
			try { 
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(getName() + " interrupted");
				break;
			}
			
		}
		System.out.println(getName() + "종료됨");
	}
}
	
