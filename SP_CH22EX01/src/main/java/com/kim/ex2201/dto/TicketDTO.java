package com.kim.ex2201.dto;

// Form�� ���ε� DTO Ŭ����
public class TicketDTO {
	private String consumerId;
	private String amount;
	
	// ������
	public TicketDTO() {
		super();
	}

	// �Ķ����
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
