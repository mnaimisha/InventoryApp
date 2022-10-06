package com.assignment.InventoryApplication.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supplierId;
	private String supplierName;
	
	@OneToMany(mappedBy="supplier")
	private List<ProductSupplier> productSupplier;

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public List<ProductSupplier> getProductSupplier() {
		return productSupplier;
	}

	public void setProductSupplier(List<ProductSupplier> productSupplier) {
		this.productSupplier = productSupplier;
	}

	public Supplier(int supplierId, String supplierName, List<ProductSupplier> productSupplier) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.productSupplier = productSupplier;
	}

	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}