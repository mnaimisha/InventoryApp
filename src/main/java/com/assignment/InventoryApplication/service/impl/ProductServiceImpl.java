package com.assignment.InventoryApplication.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.InventoryApplication.model.InventoryDetails;
import com.assignment.InventoryApplication.model.Product;
import com.assignment.InventoryApplication.repository.ProductRepository;
import com.assignment.InventoryApplication.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;
	private static Logger log = LogManager.getLogger(ProductServiceImpl.class);

	@Override
	public Product addProduct(InventoryDetails details) {
		Product productDb = getProduct(details.getCode());
		log.info("Add product details for product code :" + details.getCode());
		if (productDb == null) {
			Product product = new Product();
			product.setProductCode(details.getCode());
			product.setProductName(details.getName());
			return productRepo.save(product);
		}
		log.info("product details added");
		return productDb;
	}

	@Override
	public Product getProduct(String productCode) {
		return productRepo.findById(productCode).orElse(null);
	}

}
