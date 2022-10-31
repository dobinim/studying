package com.kim.ch12Project1;

import java.util.*;

public class MainClass02 {

	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();
//		FruitBox<Grape> grapeBox1 = new FruitBox<Apple>();  �� ����, Ÿ�� ����ġ
//		FruitBox<Toy> toyBox = new FruitBox<Toy>(); �� ����, ���׸� ���� ����ġ
		
		fruitBox.add(new Fruit());	// ������ add() �޼����  ArrayList�� add�� �ƴ϶� Box�� add �޼���
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		appleBox.add(new Apple());	
//		appleBox.add(new Grape()); 	�� ����. ��״� ���� ��Ӱ��� X �̹Ƿ� �ڱ�� �͸� ���� �� ���� 
		grapeBox.add(new Grape());
		
		System.out.println("fruitBox - " + fruitBox);
		System.out.println("appleBox - " + appleBox);
		System.out.println("grapeBox - " + grapeBox);
	}


}

class Fruit implements Eatable {
	@Override
	public String toString() {
		return "Fruit";
	}
}

interface Eatable {
	
}

class Apple extends Fruit {
	public String toString() {
		return "Apple";
	}
}

class Grape extends Fruit {
	public String toString() {
		return "Grape";
	}
}

class Toy {
	public String toString() {
		return "Toy";
	}
}

class Box<T> { 	// ����ƽ Ŭ������ ����, ��� T�� ����
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {
		list.add(item);
    }
	T get(int i) {
		return list.get(i);
	}
	int size() {
		return list.size();
	}

	public String toString() {
		return list.toString();
	}

}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {
	// FruitBox Ŭ������ Box<T> Ŭ������ ����ϰ� 
	// ����ƽ�� <T extends Fruit & Eatable>�� Fruit�� ����ϰ� Eatable�� ������ Ŭ����
	// Fruit, Apple, Grape�� ��� ����
	
}