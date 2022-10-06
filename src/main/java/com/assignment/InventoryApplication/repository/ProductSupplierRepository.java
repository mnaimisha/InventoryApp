package com.assignment.InventoryApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.InventoryApplication.model.ProductSupplier;
import com.assignment.InventoryApplication.model.Supplier;

@Repository
public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, Integer> {

	List<ProductSupplier> findBySupplier(Supplier supplier);

}
