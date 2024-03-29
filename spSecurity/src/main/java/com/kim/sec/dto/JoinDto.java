package com.kim.sec.dto;

// form과 매핑되는 DTO클래스 : DB와 매핑
public class JoinDto {

	private String pid;
	private String ppw;
	private String paddress;
	private String phobby;
	private String pprofile;
	
	public JoinDto() {
		super();
	}

	public JoinDto(String pid, String ppw, String paddress, String phobby, String pprofile) {
		super();
		this.pid = pid;
		this.ppw = ppw;
		this.paddress = paddress;
		this.phobby = phobby;
		this.pprofile = pprofile;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPpw() {
		return ppw;
	}

	public void setPpw(String ppw) {
		this.ppw = ppw;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public String getPhobby() {
		return phobby;
	}

	public void setPhobby(String phobby) {
		this.phobby = phobby;
	}

	public String getPprofile() {
		return pprofile;
	}

	public void setPprofile(String pprofile) {
		this.pprofile = pprofile;
	}
}
