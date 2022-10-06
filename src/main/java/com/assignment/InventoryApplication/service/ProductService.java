package com.assignment.InventoryApplication.service;

import com.assignment.InventoryApplication.model.InventoryDetails;
import com.assignment.InventoryApplication.model.Product;

public interface ProductService {
	public Product addProduct(InventoryDetails details);

	public Product getProduct(String productCode);

}
