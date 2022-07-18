package com.kim.booklist.dto;

import java.sql.Timestamp;

public class RBLDto {

	private int rbId;
	private String rbTitle;
	private String rbName;
	private String rbPub;
	private int rbPubYear;
	private Timestamp rbDate;
	
	
	public RBLDto() {
		super();
		
	}
	
	
	public RBLDto(int rbId, String rbTitle, String rbName, String rbPub, int rbPubYear, Timestamp rbDate) {
		super();
		this.rbId = rbId;
		this.rbTitle = rbTitle;
		this.rbName = rbName;
		this.rbPub = rbPub;
		this.rbPubYear = rbPubYear;
		this.rbDate = rbDate;
	}
	
	
	public int getRbId() {
		return rbId;
	}
	public void setRbId(int rbId) {
		this.rbId = rbId;
	}
	public String getRbTitle() {
		return rbTitle;
	}
	public void setRbTitle(String rbTitle) {
		this.rbTitle = rbTitle;
	}
	public String getRbName() {
		return rbName;
	}
	public void setRbName(String rbName) {
		this.rbName = rbName;
	}
	public String getRbPub() {
		return rbPub;
	}
	public void setRbPub(String rbPub) {
		this.rbPub = rbPub;
	}
	public int getRbPubYear() {
		return rbPubYear;
	}
	public void setRbPubYear(int rbPubYear) {
		this.rbPubYear = rbPubYear;
	}
	public Timestamp getRbDate() {
		return rbDate;
	}
	public void setRbDate(Timestamp rbDate) {
		this.rbDate = rbDate;
	}
	
	
}
