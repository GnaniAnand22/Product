package com.example.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productapp.module.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	

}
