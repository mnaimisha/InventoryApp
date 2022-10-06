package com.assignment.InventoryApplication.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.assignment.InventoryApplication.model.ProductExpiry;
import com.assignment.InventoryApplication.model.ProductStock;
import com.assignment.InventoryApplication.service.InventoryService;
import com.assignment.InventoryApplication.service.ProductSupplierService;
import com.assignment.InventoryApplication.util.CSVHelper;

@RestController
@RequestMapping("/inventoryDetailsApp")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;

	@Autowired
	ProductSupplierService productSupplierService;

	@RequestMapping(value = "/addInventoryDetails", method = RequestMethod.POST)
	public ResponseEntity<?> addInventoryDetails(@RequestParam("file") MultipartFile file) {
		if (CSVHelper.hasCSVFormat(file)) {
			try {
				inventoryService.addInventoryDetails(file);
				return new ResponseEntity<String>("Uploaded the file successfully: " + file.getOriginalFilename(),
						HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<String>("Could not upload the file: " + file.getOriginalFilename() + "!",
						HttpStatus.EXPECTATION_FAILED);
			}
		}
		return new ResponseEntity<String>("Please upload a csv file!", HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/supplierProducts/{supplier}", method = RequestMethod.GET)
	public ResponseEntity<?> getProductsBySupplier(@PathVariable("supplier") String supplierName,
			@RequestParam(required = false) String productName) {
		List<ProductStock> products = new ArrayList<ProductStock>();
		try {
			products = (productName == null) ? productSupplierService.getProductsBySupplier(supplierName)
					: productSupplierService.getProductsBySupplierAndProduct(supplierName, productName);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<ProductStock>>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/supplierExpiredProducts", method = RequestMethod.GET)
	public ResponseEntity<?> getSupplierProductsExpired(@RequestBody List<String> suppliers) {
		Map<String, List<ProductExpiry>> products = new HashMap<String, List<ProductExpiry>>();
		try {
			products = productSupplierService.getSupplierProductsExpired(suppliers);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, List<ProductExpiry>>>(products, HttpStatus.OK);
	}

}
