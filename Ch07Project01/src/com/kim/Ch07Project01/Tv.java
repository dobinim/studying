package com.kim.Ch07Project01;

public class Tv extends Object {
	// ����ϴ� Ŭ������ ��� �⺻������ object Ŭ������ ����ϰ� ����
	// ��� �ν��Ͻ� ����
	boolean power; // �⺻�� false
	int channel; // �⺻���� 0
	
	// static ������ �ν��Ͻ� ��� �޼ҵ� 
	void power() { // power = �޼��� �̸�, () = �Ű������� ���� ��
		power = !power;
		// return; void������ return�� ���� ����
	}
	
	void channelUp() {
		++channel;
	}
	
	void channelDown() {
		--channel;
	}
	
	// �����ڰ� ��������� ������ �����Ƿ� �⺻ �����ڰ� ������ ���� 
	/* 
	   �����ڴ� Ŭ���� �̸��� �̸��� ����, 
	   �⺻ �����ڴ� �Ķ���Ϳ� ���� �ƹ��͵� �Է�X
	   public Tv () {}	
	 */
}
