package com.example.bean;

import java.io.Serializable;

public class Sale implements Serializable {

	private static final long serialVersionUID = 8193103672566122260L;

	private long id;

	private String product;
	
	private Integer amount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	
}
