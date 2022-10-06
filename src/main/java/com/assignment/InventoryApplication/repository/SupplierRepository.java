package com.assignment.InventoryApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.InventoryApplication.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

	Optional<Supplier> findBySupplierName(String supplier);

}
