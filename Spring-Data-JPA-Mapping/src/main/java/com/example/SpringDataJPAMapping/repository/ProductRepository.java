package com.example.SpringDataJPAMapping.repository;

import com.example.SpringDataJPAMapping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
