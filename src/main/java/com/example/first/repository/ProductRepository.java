package com.example.first.repository;

import com.example.first.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Products, Long> {
}
