package com.company.item.model;

import java.io.Serializable;

public class Item implements Serializable{

	private String id;
	private String description;
	private String number;

	private Customer customer;

	public Item() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Item(String id, String description, String number) {
		this.id = id;
		this.description = description;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Item{" +
				"id='" + id + '\'' +
				", description='" + description + '\'' +
				", number='" + number + '\'' +
				'}';
	}
}
