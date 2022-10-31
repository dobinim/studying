package com.kim.ex0805;

public class ServerInfo {
	private String ipNum;
	private String portNum;
	
	// 기본 생성자
	public ServerInfo() {
		super();
	}
	
	// 파라메터
	public ServerInfo(String ipNum, String portNum) {
		super();
		this.ipNum = ipNum;
		this.portNum = portNum;
	}
	
	// getter, setter
	public String getIpNum() {
		return ipNum;
	}
	public void setIpNum(String ipNum) {
		this.ipNum = ipNum;
	}
	public String getPortNum() {
		return portNum;
	}
	public void setPortNum(String portNum) {
		this.portNum = portNum;
	}
	
	
}
