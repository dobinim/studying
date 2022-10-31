package com.kim.ch12Project1;

import java.util.ArrayList;
import java.util.List;
public class MainClass01 {

	public static void main(String[] args) {
		ArrayList<Product> productList = new ArrayList<Product>();
		// public class ArrayList<E>는 지네틱 클래스로, 타입문자 E 사용
		// ArrayList 객체 선언 시 지네릭을 사용 (데이터형 Product)
		// 생성자의 지네틱도 선언 시의 지네틱과 동일해야함. new ArrayList<Product>();
		// 동일하면 생성자에선 생략 OK! - Java 1.7
		// But, Spring과의 연계나 이런 것에서 버전 안맞아 에러 뜰 수 있으므로
		// 가급적 그냥 작성하는걸 권장함!
		productList.add(new Product());
		ArrayList<Tv> tvList = new ArrayList<Tv>();
		// ArrayList<Product> tvList1 = new ArrayList<Tv>;
		// 선언과 생성자의 지네틱 타입이 다르므로 에러
		List<Tv> tvList2 = new ArrayList<Tv>();
		// 이건 OK. WHhy?
		// 지네릭은 Tv로 같으니 정상. List는 ArrayList의 상위 인터페이스라
		// 다형성으로 인해 OKOK. 
		
		productList.add(new Tv()); 
		// public boolean add(E e)로 Product 객체가 와야 하지만 하위 객체가 와도 OK (다형성)
		productList.add(new Audio());
		
		Product p = productList.get(0);	// 자신 Product이므로 형변환 필요 X 
		Tv tv1 = (Tv)productList.get(1);	
		// Product 클래스의 하위 클래스이므로 형변환
		// Tv가 하위객체라 이렇게 써도 OK (뒤는 형변환 해줌)
		
		tvList.add(new Tv());	// 지네릭으로 지정한 인스턴스이므로 가능
		tvList.add(new Tv());
		
		printAll(productList);
		System.out.println("=========");
		// printAll(tvList);  → 에러남. why?
		// printAll() 메서드는 지네릭을 <Product>로 받는데, 
		// tvList는 지네릭이 <Tv>이기 때문.
	}

	// static에서 자신 클래스의 지네틱은 사용 불가이나, JDK 제공 클래스가 지네틱일시 사용 ok.
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