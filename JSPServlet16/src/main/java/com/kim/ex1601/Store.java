package com.kim.ex1601;

public class Store {
	// ��� ����
	private String id;
	private String code;
	private String product;
	private int price;
	private boolean flag;
	
	// �⺻ ������
	public Store() {
		super();
		
	}

	// ��� ��������� �ʱ�ȭ�ϴ� ������
	public Store(String id, String code, String product, int price, boolean flag) {
		super();
		this.id = id;
		this.code = code;
		this.product = product;
		this.price = price;
		this.flag = flag;
	}

	
				// getter, setter �޼���
	// id�� getter�� setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// code�� getter�� setter
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	// product�� getter�� setter
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	// price�� getter�� setter
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// flag�� getter�� setter
	public boolean isFlag() {	// boolean�� get�� �ƴ϶� is�� ����! �� �ǳ� Ʋ����
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
