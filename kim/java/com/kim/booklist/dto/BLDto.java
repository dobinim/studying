package com.kim.booklist.dto;

import java.sql.Timestamp;

public class BLDto {

	private int bId;
	private String bTitle;
	private String bName;
	private String bPub;
	private int bPubYear;
	private Timestamp bDate;
	
	public BLDto() {
		super();
	}

	public BLDto(int bId, String bTitle, String bName, String bPub, int bPubYear, Timestamp bDate) {
		super();
		this.bId = bId;
		this.bTitle = bTitle;
		this.bName = bName;
		this.bPub = bPub;
		this.bPubYear = bPubYear;
		this.bDate = bDate;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbPub() {
		return bPub;
	}

	public void setbPub(String bPub) {
		this.bPub = bPub;
	}

	public int getbPubYear() {
		return bPubYear;
	}

	public void setbPubYear(int bPubYear) {
		this.bPubYear = bPubYear;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}
	
	
	
	
	
}
