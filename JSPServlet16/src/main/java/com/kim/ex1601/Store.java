package com.kim.ex1601;

public class Store {
	// 멤버 변수
	private String id;
	private String code;
	private String product;
	private int price;
	private boolean flag;
	
	// 기본 생성자
	public Store() {
		super();
		
	}

	// 모든 멤버변수를 초기화하는 생성자
	public Store(String id, String code, String product, int price, boolean flag) {
		super();
		this.id = id;
		this.code = code;
		this.product = product;
		this.price = price;
		this.flag = flag;
	}

	
				// getter, setter 메서드
	// id의 getter와 setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// code의 getter와 setter
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	// product의 getter와 setter
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	// price의 getter와 setter
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// flag의 getter와 setter
	public boolean isFlag() {	// boolean은 get이 아니라 is로 나옴! → 옳냐 틀리냐
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
