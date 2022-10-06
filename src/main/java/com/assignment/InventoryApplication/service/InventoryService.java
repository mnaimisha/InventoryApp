package com.assignment.InventoryApplication.service;

import org.springframework.web.multipart.MultipartFile;

public interface InventoryService {

	public void addInventoryDetails(MultipartFile file) throws Exception;

}
