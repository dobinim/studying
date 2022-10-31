package com.kim.ch12Project1;

import java.util.HashMap;
import java.util.Map;

public class QuizClass01 {

	public static void main(String[] args) {

		// 1�� 
		Map<String,Integer> map = new HashMap<String, Integer>();
		// HashMap<String, int> map1 = new HashMap<String, int>(); �� ����
		// ���׸��� Ÿ�Ժ����� "������" �̾�� �Ѵ�
		
		Product2<String> product = new Product2<String>();	// 2��
		// �ν��Ͻ��� ����, ���� �� ���� ������ ������ Ÿ���� ���
		
		Level myVar = Level.MEDIUM;
		// Level myVar;
		// myVar = Level.MEDIUM;
		System.out.println(myVar); 	// 3��
		
		
		Level[] LevelArr = Level.values();
		for (Level l : LevelArr) {
			System.out.println("������� " + l.name()); // ���ι�ȣ�� l.ordinal
		}			// 4�� 
		
		 		// 5��
		switch (myVar) {
		case LOW:	// case �������� Level�� ������ ����� ���
			System.out.println("The Level is LOW");
			break;
		case MEDIUM:
			System.out.println("The Level is MEDIUM");
			break;
		default:
			System.out.println("The Level is HIGH");
			break;
		} 
		
	}			// �ѤѤѤѤѤѤѤ� ���� ��

	enum Level {			// 3��
		LOW, MEDIUM, HIGH
}
	
	
}				// �ѤѤѤѤѤѤѤ� Ŭ���� ��

// ���׸� Ŭ���� ���� �� Ÿ�� ������ T, E, K, V.. ���� ����Ͽ� �����
class Product2 <T> { 			// 2 ��
	T p;
	T example (T t) {
		T ret = t;
		return ret;
	}
}




/* 
 * 1. Ÿ�� �Ķ���Ͱ� String�� Integer�� map ��ü ����
 * 2. ����ƽŬ���� Product2�� ����
 * 		- Ÿ���Ķ���͸� �̿��� ������� p�� ������
 * 		- Ÿ���Ķ���͸� �̿��� ����Ÿ�԰� Ÿ���Ķ���Ͱ� ����� �޼��� ����
 * 			( ) example (() t) {
 * 				() ret = t;
 * 				return ret;
 * 			}
 *		- Main �޼��忡�� Product ��ü�� StringŸ���Ķ���͸� �̿��� ������
 * 3. QuizTest Ŭ���� �ȿ� enum Level�� ����� ����� LOW, MEDIUM, HIGH�� ������
 * 		- Level �ν��Ͻ� myVar ���� �� ���� MEDIUM�� �־��
 * 		- myVar ���
 * 4. enum Level�� ������� for���� �̿��� ���
 * 5. Level enum�� switch�� ����
 * 
 */