package com.kim.sp2101.dto;

// Ŭ���̾�Ʈ writeForm.jsp�� form�� ���εǴ� DTOŬ����
public class WriteFormDTO {
	private String bName;
	private String bTitle;
	private String bContent;
	
	// �⺻ ������
	public WriteFormDTO() {
		super();
	}
	
	// �Ķ���� 
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
