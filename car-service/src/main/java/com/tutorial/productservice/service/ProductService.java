package com.tutorial.productservice.service;

import com.tutorial.productservice.entity.Product;
import com.tutorial.productservice.repository.productRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    productRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product save(Product product) {
        Product productNew = productRepository.save(product);
        return productNew;
    }

    public List<Product> byUserId(int userId) {
        return productRepository.findByUserId(userId);
    }
}
