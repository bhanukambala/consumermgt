package com.dxctraining.consumer.entities;

import javax.persistence.*;

@Entity
@Table(name="consumers")
public class Consumer {
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	public Consumer(String name) {
		this.name=name;
	}
	public Consumer() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		Consumer that = (Consumer) obj;
		return this.id== that.id;
	}
}
