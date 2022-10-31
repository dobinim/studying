package com.kim.batis01.dto;

public class TicketDto {
	private String consumerId;
	private String amount;
	
	
	public TicketDto() {
		super();
	
	}
	
	
	public TicketDto(String consumerId, String amount) {
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
