package com.gcu.model;

public class ProductModel {
	
	
	private Long id;
	private String productNo;
	private String productName;
	private Float price;
	private int quantity;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	public ProductModel(Long id, String productNo, String productName, Float price, int quantity) {
		super();
		this.id = id;
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	
	

}
