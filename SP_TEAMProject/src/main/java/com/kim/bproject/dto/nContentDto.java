package com.kim.bproject.dto;

import java.io.File;
import java.sql.Date;

public class nContentDto {		// ���������� Dto
	private int nId;			// id
	private String nTitle;		// ����
	private String nWriter;		// �ۼ���
	private Date nDate;			// �ۼ���¥
	private String nContent;	// ����
	private File nFile;			// ÷������
	
	public nContentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public nContentDto(int nId, String nTitle, String nWriter, Date nDate, String nContent, File nFile) {
		super();
		this.nId = nId;
		this.nTitle = nTitle;
		this.nWriter = nWriter;
		this.nDate = nDate;
		this.nContent = nContent;
		this.nFile = nFile;
	}

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnWriter() {
		return nWriter;
	}

	public void setnWriter(String nWriter) {
		this.nWriter = nWriter;
	}

	public Date getnDate() {
		return nDate;
	}

	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public File getnFile() {
		return nFile;
	}

	public void setnFile(File nFile) {
		this.nFile = nFile;
	}
	
	
	
}
