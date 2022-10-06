package com.assignment.InventoryApplication.service;

import java.util.List;

import com.assignment.InventoryApplication.model.InventoryDetails;
import com.assignment.InventoryApplication.model.Supplier;

public interface SupplierService {
	
	public Supplier addSupplier(InventoryDetails details);

	public Supplier getSupplier(String supplierName);

	public List<Supplier> getSuppliersByName(List<String> supplierNames);

}
