package com.kim.bproject.dto;

public class RbContentDto {
	private int RbookId;				// id
	private String RbookTitle;			// 책 제목
	private String RbookOriTitle;		// 원제
	private String Rwriter;				// 작가
	private String RbookType;			// 일반자료/멀티미디어
	private String Rpublisher;			// 출판사
	private String Rform;				// 쪽수, 크기(세로)
	private String Risbn;				// isbn 번호
	private String RbookContent;		// 서평
	private String RbookWriter;			// 작가/번역가 포함
	private String RbookIndex;			// 목차
	private String Rgenre;				// 장르
	private String Ryear;				// 출판년도
	
	public RbContentDto() {
		super();
	}

	public RbContentDto(int rbookId, String rbookTitle, String rbookOriTitle, String rwriter, String rbookType,
			String rpublisher, String rform, String risbn, String rbookContent, String rbookWriter, String rbookIndex,
			String rgenre, String ryear) {
		super();
		RbookId = rbookId;
		RbookTitle = rbookTitle;
		RbookOriTitle = rbookOriTitle;
		Rwriter = rwriter;
		RbookType = rbookType;
		Rpublisher = rpublisher;
		Rform = rform;
		Risbn = risbn;
		RbookContent = rbookContent;
		RbookWriter = rbookWriter;
		RbookIndex = rbookIndex;
		Rgenre = rgenre;
		Ryear = ryear;
	}

	public int getRbookId() {
		return RbookId;
	}

	public void setRbookId(int rbookId) {
		RbookId = rbookId;
	}

	public String getRbookTitle() {
		return RbookTitle;
	}

	public void setRbookTitle(String rbookTitle) {
		RbookTitle = rbookTitle;
	}

	public String getRbookOriTitle() {
		return RbookOriTitle;
	}

	public void setRbookOriTitle(String rbookOriTitle) {
		RbookOriTitle = rbookOriTitle;
	}

	public String getRwriter() {
		return Rwriter;
	}

	public void setRwriter(String rwriter) {
		Rwriter = rwriter;
	}

	public String getRbookType() {
		return RbookType;
	}

	public void setRbookType(String rbookType) {
		RbookType = rbookType;
	}

	public String getRpublisher() {
		return Rpublisher;
	}

	public void setRpublisher(String rpublisher) {
		Rpublisher = rpublisher;
	}

	public String getRform() {
		return Rform;
	}

	public void setRform(String rform) {
		Rform = rform;
	}

	public String getRisbn() {
		return Risbn;
	}

	public void setRisbn(String risbn) {
		Risbn = risbn;
	}

	public String getRbookContent() {
		return RbookContent;
	}

	public void setRbookContent(String rbookContent) {
		RbookContent = rbookContent;
	}

	public String getRbookWriter() {
		return RbookWriter;
	}

	public void setRbookWriter(String rbookWriter) {
		RbookWriter = rbookWriter;
	}

	public String getRbookIndex() {
		return RbookIndex;
	}

	public void setRbookIndex(String rbookIndex) {
		RbookIndex = rbookIndex;
	}

	public String getRgenre() {
		return Rgenre;
	}

	public void setRgenre(String rgenre) {
		Rgenre = rgenre;
	}

	public String getRyear() {
		return Ryear;
	}

	public void setRyear(String ryear) {
		Ryear = ryear;
	}
	
	
	
	
}
