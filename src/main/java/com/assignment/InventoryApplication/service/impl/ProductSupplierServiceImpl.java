package com.assignment.InventoryApplication.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.InventoryApplication.model.InventoryDetails;
import com.assignment.InventoryApplication.model.Product;
import com.assignment.InventoryApplication.model.ProductExpiry;
import com.assignment.InventoryApplication.model.ProductStock;
import com.assignment.InventoryApplication.model.ProductSupplier;
import com.assignment.InventoryApplication.model.Supplier;
import com.assignment.InventoryApplication.repository.ProductRepository;
import com.assignment.InventoryApplication.repository.ProductSupplierRepository;
import com.assignment.InventoryApplication.repository.SupplierRepository;
import com.assignment.InventoryApplication.service.ProductService;
import com.assignment.InventoryApplication.service.ProductSupplierService;
import com.assignment.InventoryApplication.service.SupplierService;
import com.assignment.InventoryApplication.util.CSVHelper;

@Service
public class ProductSupplierServiceImpl implements ProductSupplierService {

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

	private static Logger log = LogManager.getLogger(ProductSupplierServiceImpl.class);

	@Override
	public ProductSupplier addProductSupplier(Product product, Supplier supplier, InventoryDetails detail) {
		ProductSupplier productSupplier = new ProductSupplier();
		productSupplier.setCompany(detail.getCompany());
		productSupplier.setExpiry(detail.getExp());
		productSupplier.setFree(detail.getFree());
		productSupplier.setMrp(detail.getMrp());
		productSupplier.setRate(detail.getRate());
		productSupplier.setProduct(product);
		productSupplier.setSupplier(supplier);
		productSupplier.setBatch(detail.getBatch());
		log.info("Product Supplier details added");
		return productSupplierRepo.save(productSupplier);
	}

	@Override
	public List<ProductStock> getProductsBySupplier(String supplierName) {
		log.info("Supplier product List");
		Supplier suppliers = supplierService.getSupplier(supplierName);
		List<ProductStock> productStocks = new ArrayList<ProductStock>();
		List<ProductSupplier> productSupplier = getProductSupplierBySupplierName(suppliers);
		for (ProductSupplier supplier : productSupplier) {
			Product product = productService.getProduct(supplier.getProduct().getProductCode());
			ProductStock stock = new ProductStock(product.getProductName(), product.getProductCode(),
					supplier.getStock());
			productStocks.add(stock);
		}
		log.info("Supplier product List returned");
		return productStocks;
	}

	@Override
	public List<ProductStock> getProductsBySupplierAndProduct(String supplierName, String productName) {
		log.info("List of supplier products based on supplier name, product name");
		List<ProductStock> productStocks = new ArrayList<ProductStock>();
		for (ProductStock productStock : getProductsBySupplier(supplierName)) {
			if (productName.equals(productStock.getProductName()))
				productStocks.add(productStock);
		}
		return productStocks;
	}

	@Override
	public Map<String, List<ProductExpiry>> getSupplierProductsExpired(List<String> supplierNames) {
		log.info("Supplier expired products");
		List<Supplier> suppliers = supplierService.getSuppliersByName(supplierNames);
		Map<String, List<ProductExpiry>> supplierProductsExpire = new HashMap<String, List<ProductExpiry>>();
		for (Supplier supplier : suppliers) {
			List<ProductSupplier> productSupplier = getProductSupplierBySupplierName(supplier);
			supplierProductsExpire.put(supplier.getSupplierName(), getProductsExpired(productSupplier));
		}
		return supplierProductsExpire;
	}

	private List<ProductSupplier> getProductSupplierBySupplierName(Supplier supplier) {
		return productSupplierRepo.findBySupplier(supplier);
	}

	public List<ProductExpiry> getProductsExpired(List<ProductSupplier> productSuppliers) {
		log.info("products expired");
		List<ProductExpiry> productsExpired = new ArrayList<ProductExpiry>();
		for (ProductSupplier productSupplier : productSuppliers) {
			if (productSupplier.getExpiry() != null) {
				if (productSupplier.getExpiry().before(new Date())) {
					Product product = productService.getProduct((productSupplier.getProduct().getProductCode()));
					productsExpired.add(new ProductExpiry(product.getProductCode(), product.getProductName(),
							productSupplier.getExpiry()));
				}
			}
		}

		return productsExpired;
	}

}
