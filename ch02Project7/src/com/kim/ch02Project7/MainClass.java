package com.kim.ch02Project7;

public class MainClass {

	public static void main(String[] args) {
		
		short sMin = -32768, sMax = 32767;
		// short �� 2����Ʈ(16��Ʈ)�̹Ƿ� ǥ�� ������ ���� 2^16��, ��, 65536����,
		// ǥ�� ���� ������ -2^16 (-32768) ~ 2^16-1 (32767) ������ 
		char cMin = 0, cMax = 65535; 
		// �������� ��ȣ�� ���� ���� (-�� X)�� 0���� ����, ���� �� �ƴ϶� �����ڵ带 �̿��� ���ڷε� ��Ÿ�� �� �ִ�
		System.out.println("sMin = " + sMin);
		System.out.println("sMin-1 = " + (short)(sMin-1));
		// �ּҰ����� -1�ϸ� �ִ밪���� ���´�  (overflow)
		System.out.println("sMax = " + sMax);
		System.out.println("sMax + 1 = " + (short)(sMax+1));
		// �ִ밪���� +1�ϸ� �ּҰ����� ���´� (overflow) �� ����ȯ ó�� 
		System.out.println("cMin = " + (int)cMin);
		// char�� int������ ����ȯ�ϴ� int����ȯ
		System.out.println("cMin - 1 = " + (int)--cMin);
		// --�� ���տ����ڷ� 1�� ���ҽ�Ű�� ������
		// �ִ밪���� ���� (cMin - 1 = cMax)
		System.out.println("cMax = " + cMax);
		// cMax�� ������ ?����, ����Ÿ������ �ϸ� 65535�� ��
		System.out.println("cMax + 1 = " + (int)++cMax);
		// ++�� �����ڷ� 1�� ���ϴ� ������
		// �ּҰ����� ���� (cMax + 1 = cMin)
		System.out.println((char)65); // �� ū int�� 64�� ���� char������ ����ȯ
		System.out.println((int)1.5f); // �� ū float���� int������ ����ȯ
		
		// ����ȯ => (����ȯ�ϰ��� �ϴ� ������ ����)��  ��)(char)65 / (int)A ���� �͵� 
		
	}

}
