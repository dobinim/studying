package com.kim.ex2201.dto;

// Form의 맵핑된 DTO 클래스
public class TicketDTO {
	private String consumerId;
	private String amount;
	
	// 생성자
	public TicketDTO() {
		super();
	}

	// 파라메터
	public TicketDTO(String consumerId, String amount) {
		super();
		this.consumerId = consumerId;
		this.amount = amount;
	}
	
	// getter, setter
	public String getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
