package com.tutorial.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.productservice.entity.Product;

import java.util.List;

@Repository
public interface productRepository extends JpaRepository<Product, Integer> {

    List<Product> findByUserId(int userId);
}
