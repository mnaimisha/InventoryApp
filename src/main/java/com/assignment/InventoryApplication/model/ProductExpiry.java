package com.assignment.InventoryApplication.model;

import java.util.Date;

public class ProductExpiry {
	private String productCode;
	private String productName;
	private Date expiryDate;
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
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public ProductExpiry(String productCode, String productName, Date expiryDate) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.expiryDate = expiryDate;
	}
	

}
