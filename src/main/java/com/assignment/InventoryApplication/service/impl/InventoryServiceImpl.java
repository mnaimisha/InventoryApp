package com.assignment.InventoryApplication.service.impl;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.assignment.InventoryApplication.model.InventoryDetails;
import com.assignment.InventoryApplication.model.Product;
import com.assignment.InventoryApplication.model.Supplier;
import com.assignment.InventoryApplication.repository.ProductSupplierRepository;
import com.assignment.InventoryApplication.repository.ProductRepository;
import com.assignment.InventoryApplication.repository.SupplierRepository;
import com.assignment.InventoryApplication.service.InventoryService;
import com.assignment.InventoryApplication.service.ProductService;
import com.assignment.InventoryApplication.service.ProductSupplierService;
import com.assignment.InventoryApplication.service.SupplierService;
import com.assignment.InventoryApplication.util.CSVHelper;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	CSVHelper csvHelper;
	@Autowired
	ProductRepository productRepo;
	@Autowired
	SupplierRepository supplierRepo;
	@Autowired
	ProductSupplierRepository productSupplierRepo;
	@Autowired
	ProductService productService;
	@Autowired
	SupplierService supplierService;
	@Autowired
	ProductSupplierService productSupplierService;

	private static Logger log=LogManager.getLogger(InventoryServiceImpl.class);
	
	@Override
	public void addInventoryDetails(MultipartFile file) throws Exception {
		try {
			List<InventoryDetails> details = CSVHelper.csvToList(file.getInputStream());
			log.info("converted csv to list");
			for (InventoryDetails detail : details) {
				Product product = productService.addProduct(detail);
				Supplier supplier = supplierService.addSupplier(detail);
				productSupplierService.addProductSupplier(product, supplier, detail);
				log.info("added inventory details");
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception(e.getMessage());
		}
	}



}
