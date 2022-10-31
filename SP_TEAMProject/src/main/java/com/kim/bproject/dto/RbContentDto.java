package com.kim.bproject.dto;

public class RbContentDto {
	private int RbookId;				// id
	private String RbookTitle;			// å ����
	private String RbookOriTitle;		// ����
	private String Rwriter;				// �۰�
	private String RbookType;			// �Ϲ��ڷ�/��Ƽ�̵��
	private String Rpublisher;			// ���ǻ�
	private String Rform;				// �ʼ�, ũ��(����)
	private String Risbn;				// isbn ��ȣ
	private String RbookContent;		// ����
	private String RbookWriter;			// �۰�/������ ����
	private String RbookIndex;			// ����
	private String Rgenre;				// �帣
	private String Ryear;				// ���ǳ⵵
	
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
