package com.assignment.InventoryApplication.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductSupplier {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productSupplierId;
	private String batch;
	private int stock;
	private int deal;
	private int free;
	private double mrp;
	private double rate;
	private String company;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	private Date expiry;
	@ManyToOne
	private Product product;
	@ManyToOne
	private Supplier supplier;
	public int getProductSupplierId() {
		return productSupplierId;
	}
	public void setProductSupplierId(int productSupplierId) {
		this.productSupplierId = productSupplierId;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getDeal() {
		return deal;
	}
	public void setDeal(int deal) {
		this.deal = deal;
	}
	public int getFree() {
		return free;
	}
	public void setFree(int free) {
		this.free = free;
	}
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public Date getExpiry() {
		return expiry;
	}
	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public ProductSupplier(int productSupplierId, String batch, int stock, int deal, int free, double mrp, double rate,
			String company, Date expiry, Product product, Supplier supplier) {
		super();
		this.productSupplierId = productSupplierId;
		this.batch = batch;
		this.stock = stock;
		this.deal = deal;
		this.free = free;
		this.mrp = mrp;
		this.rate = rate;
		this.company = company;
		this.expiry = expiry;
		this.product = product;
		this.supplier = supplier;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public ProductSupplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
