package com.assignment.InventoryApplication.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.InventoryApplication.model.InventoryDetails;
import com.assignment.InventoryApplication.model.Supplier;
import com.assignment.InventoryApplication.repository.SupplierRepository;
import com.assignment.InventoryApplication.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	SupplierRepository supplierRepo;

	private static Logger log = LogManager.getLogger(SupplierServiceImpl.class);

	@Override
	public Supplier addSupplier(InventoryDetails details) {
		Supplier suppliers = getSupplier(details.getSupplier());
		log.info("add supplier details for supplier named :" + details.getSupplier());
		if (suppliers != null) {
			Supplier supplier = new Supplier();
			supplier.setSupplierName(details.getSupplier());
			return supplierRepo.save(supplier);
		}
		log.info("supplier details added");
		return suppliers;
	}

	@Override
	public Supplier getSupplier(String supplierName) {
		return supplierRepo.findBySupplierName(supplierName).orElse(null);
	}

	@Override
	public List<Supplier> getSuppliersByName(List<String> supplierNames) {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		for (String supplierName : supplierNames) {
			suppliers.add(getSupplier(supplierName));
		}
		log.info("returned suppliers list by name");
		return suppliers;
	}

}
