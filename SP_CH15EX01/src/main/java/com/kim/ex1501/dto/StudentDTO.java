package com.kim.ex1501.dto;

// form���� ������ �Ķ���Ϳ� ���εǴ� DTO
/*  Controller���� DTO��ü�� �Ķ���ͷ� ����ϴ� RequestMapping�� ����ϸ� 
 	���������� �ڵ������� ����ȯ�ȴ�. 								*/ 
public class StudentDTO {
	private String name;
	private int id;
	
	// ������
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// �Ķ����
	public StudentDTO(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
