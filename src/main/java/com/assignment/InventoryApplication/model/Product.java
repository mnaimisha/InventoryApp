package com.assignment.InventoryApplication.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {
	
	@Id
	private String productCode;
	private String productName;
	@OneToMany(mappedBy="product")
	private List<ProductSupplier> productSupplier;
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
	
	public Product(String productCode, String productName, List<ProductSupplier> productSupplier) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productSupplier = productSupplier;
	}
	public List<ProductSupplier> getProductSupplier() {
		return productSupplier;
	}
	public void setProductSupplier(List<ProductSupplier> productSupplier) {
		this.productSupplier = productSupplier;
	}
	public Product()
	{
		
	}
	

}
