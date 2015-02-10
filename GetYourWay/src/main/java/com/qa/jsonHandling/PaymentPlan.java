package com.qa.jsonHandling;

public class PaymentPlan {
	
	private String name;
	private long length;
	private double price;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
	   return "DataObject [name=" + name + ", length=" + length + ", price="
		+ price + "]";
	}

}
