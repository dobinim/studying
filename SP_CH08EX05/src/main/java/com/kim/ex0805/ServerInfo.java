package com.kim.ex0805;

public class ServerInfo {
	private String ipNum;
	private String portNum;
	
	// �⺻ ������
	public ServerInfo() {
		super();
	}
	
	// �Ķ����
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
