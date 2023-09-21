package com.ssafy.sample.dto;

public class Product {
	private int idx;
	private String name;
	private int price;
	private String describe;
	
	
	public Product() {}
	
	
	
	
	
	public Product(int idx, String name, int price, String describe) {
		super();
		this.idx = idx;
		this.name = name;
		this.price = price;
		this.describe = describe;
	}





	public int getIdx() {
		return idx;
	}





	public void setIdx(int idx) {
		this.idx = idx;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public int getPrice() {
		return price;
	}





	public void setPrice(int price) {
		this.price = price;
	}





	public String getDescribe() {
		return describe;
	}





	public void setDescribe(String describe) {
		this.describe = describe;
	}





	@Override
	public String toString() {
		return "Product [idx=" + idx + ", name=" + name + ", price=" + price + ", describe=" + describe + "]";
	}
	
	
	
	
}
