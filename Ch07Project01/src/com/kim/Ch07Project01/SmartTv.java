package com.kim.Ch07Project01;

// extends Ű���带 ����� Tv Ŭ������ ���
// Tv�� Parent Ŭ�����̰� SmartTv�� Child Ŭ�����̴�

public class SmartTv extends Tv {
	// Tv Ŭ������ (Object Ŭ������ ���Ե�)�� ���
	// ����� �������, ����޼��常 ����ϰ� �����ڿ� �ʱ�ȭ����� ����
	// TvŬ������ ��������� �߰��� ����� ��� ����
	boolean caption;
	// Tv Ŭ������ ����޼��忡 �߰��� ����� ��� �޼���
	void displayCaption(String text) {
		if(caption) {
			System.out.println(text);
		}
	}
	
	
	// �⺻ �����ڴ� ��������� ǥ�� X �� ���������� ǥ��Ǿ� ����
	// SmartTv() {}
}
