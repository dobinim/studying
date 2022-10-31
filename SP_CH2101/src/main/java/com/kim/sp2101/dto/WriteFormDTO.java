package com.kim.sp2101.dto;

// 클라이언트 writeForm.jsp의 form과 매핑되는 DTO클래스
public class WriteFormDTO {
	private String bName;
	private String bTitle;
	private String bContent;
	
	// 기본 생성자
	public WriteFormDTO() {
		super();
	}
	
	// 파라메터 
	public WriteFormDTO(String bName, String bTitle, String bContent) {
		super();
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
	}
	
	// setter, getter
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	
	
}
