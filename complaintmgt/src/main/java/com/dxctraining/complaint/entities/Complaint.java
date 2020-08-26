package com.dxctraining.complaint.entities;

import javax.persistence.*;

@Entity
@Table(name = "complaints")
public class Complaint {
	@Id
	@GeneratedValue
	private int id;
	
	private int consumerId;

	private String description;

	public Complaint(String description,int consumerId) {
		this.description = description;
	}

	public Complaint() {

	}

	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
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

	public int hashCode() {
		return id;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		Complaint that = (Complaint) obj;
		return this.id == that.id;
	}
}
