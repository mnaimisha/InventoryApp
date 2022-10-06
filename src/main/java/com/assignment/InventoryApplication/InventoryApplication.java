package com.assignment.InventoryApplication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryApplication {
	private static Logger log=LogManager.getLogger(InventoryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
		log.info("started main application");
	}

}
