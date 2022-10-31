package com.kim.ex1301.DTO;

// 클라이언트에서 전달하는 파라메터와 같은 멤버 변수를 가진 DTO 클래스 
public class Member {
	private String name;
	private String id;
	private String pw;
	private String email;
	
	// 생성자
	public Member() {
		super();
		
	}

	public Member(String name, String id, String pw, String email) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.email = email;
	}

	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
