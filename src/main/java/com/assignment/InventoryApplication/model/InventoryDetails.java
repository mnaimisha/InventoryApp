package com.assignment.InventoryApplication.model;

import java.util.Date;

public class InventoryDetails {

	private String code;
	private String name;
	private String batch;
	private int stock;
	private int deal;
	private int free;
	private double mrp;
	private double rate;
	private Date exp;

	public int getDeal() {
		return deal;
	}

	public void setDeal(int deal) {
		this.deal = deal;
	}

	private String company;
	private String supplier;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getExp() {
		return exp;
	}

	public void setExp(Date exp) {
		this.exp = exp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public InventoryDetails(String code, String name, String batch, int stock, int deal, int free, double mrp,
			double rate, Date exp, String company, String supplier) {
		super();
		this.code = code;
		this.name = name;
		this.batch = batch;
		this.stock = stock;
		this.free = free;
		this.mrp = mrp;
		this.rate = rate;
		this.exp = exp;
		this.company = company;
		this.supplier = supplier;
		this.deal = deal;
	}

	public InventoryDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

}
