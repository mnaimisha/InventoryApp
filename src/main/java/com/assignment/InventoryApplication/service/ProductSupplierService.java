package com.assignment.InventoryApplication.service;

import java.util.List;
import java.util.Map;

import com.assignment.InventoryApplication.model.InventoryDetails;
import com.assignment.InventoryApplication.model.Product;
import com.assignment.InventoryApplication.model.ProductExpiry;
import com.assignment.InventoryApplication.model.ProductStock;
import com.assignment.InventoryApplication.model.ProductSupplier;
import com.assignment.InventoryApplication.model.Supplier;

public interface ProductSupplierService {

	public ProductSupplier addProductSupplier(Product product, Supplier supplier, InventoryDetails detail);

	public List<ProductStock> getProductsBySupplier(String supplierName);

	public List<ProductStock> getProductsBySupplierAndProduct(String supplierName, String productName);

	public Map<String, List<ProductExpiry>> getSupplierProductsExpired(List<String> supplierNames);

}
