package com.kim.ch12Project1;

import java.util.ArrayList;
import java.util.List;
public class MainClass01 {

	public static void main(String[] args) {
		ArrayList<Product> productList = new ArrayList<Product>();
		// public class ArrayList<E>�� ����ƽ Ŭ������, Ÿ�Թ��� E ���
		// ArrayList ��ü ���� �� ���׸��� ��� (�������� Product)
		// �������� ����ƽ�� ���� ���� ����ƽ�� �����ؾ���. new ArrayList<Product>();
		// �����ϸ� �����ڿ��� ���� OK! - Java 1.7
		// But, Spring���� ���質 �̷� �Ϳ��� ���� �ȸ¾� ���� �� �� �����Ƿ�
		// ������ �׳� �ۼ��ϴ°� ������!
		productList.add(new Product());
		ArrayList<Tv> tvList = new ArrayList<Tv>();
		// ArrayList<Product> tvList1 = new ArrayList<Tv>;
		// ����� �������� ����ƽ Ÿ���� �ٸ��Ƿ� ����
		List<Tv> tvList2 = new ArrayList<Tv>();
		// �̰� OK. WHhy?
		// ���׸��� Tv�� ������ ����. List�� ArrayList�� ���� �������̽���
		// ���������� ���� OKOK. 
		
		productList.add(new Tv()); 
		// public boolean add(E e)�� Product ��ü�� �;� ������ ���� ��ü�� �͵� OK (������)
		productList.add(new Audio());
		
		Product p = productList.get(0);	// �ڽ� Product�̹Ƿ� ����ȯ �ʿ� X 
		Tv tv1 = (Tv)productList.get(1);	
		// Product Ŭ������ ���� Ŭ�����̹Ƿ� ����ȯ
		// Tv�� ������ü�� �̷��� �ᵵ OK (�ڴ� ����ȯ ����)
		
		tvList.add(new Tv());	// ���׸����� ������ �ν��Ͻ��̹Ƿ� ����
		tvList.add(new Tv());
		
		printAll(productList);
		System.out.println("=========");
		// printAll(tvList);  �� ������. why?
		// printAll() �޼���� ���׸��� <Product>�� �޴µ�, 
		// tvList�� ���׸��� <Tv>�̱� ����.
	}

	// static���� �ڽ� Ŭ������ ����ƽ�� ��� �Ұ��̳�, JDK ���� Ŭ������ ����ƽ�Ͻ� ��� ok.
	private static void printAll(ArrayList<Product> list) {
		for (Product p : list) {
			System.out.println(p);
		}
		
	}

}

class Product {
	
}

class Tv extends Product {
	
}

class Audio extends Product {
	
}