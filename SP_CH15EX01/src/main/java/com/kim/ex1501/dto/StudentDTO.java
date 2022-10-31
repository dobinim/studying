package com.kim.ex1501.dto;

// form에서 보내는 파라메터와 매핑되는 DTO
/*  Controller에서 DTO객체를 파라메터로 사용하는 RequestMapping을 사용하면 
 	데이터형이 자동적으로 형변환된다. 								*/ 
public class StudentDTO {
	private String name;
	private int id;
	
	// 생성자
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// 파라메터
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
