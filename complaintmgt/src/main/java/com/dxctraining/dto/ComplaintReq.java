package com.dxctraining.dto;

public class ComplaintReq {
	private String description;
	
	private int id;
	private int consumerId;
	
	public ComplaintReq(int consumerId,String description) {
		this.consumerId=consumerId;
		this.description=description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}
	
}
