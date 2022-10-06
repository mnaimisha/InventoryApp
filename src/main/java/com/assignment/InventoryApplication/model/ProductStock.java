package com.assignment.InventoryApplication.model;

public class ProductStock {
	private String productCode;
	private String productName;
	private int stock;

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public ProductStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductStock(String productCode, String productName, int stock) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.stock = stock;
	}

}
