package com.tutorial.productservice.controller;

import com.tutorial.productservice.entity.Product;
import com.tutorial.productservice.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = productService.getAll();
        if(products.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") int id) {
        Product product = productService.getProductById(id);
        if(product == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(product);
    }

    @PostMapping()
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product productNew = productService.save(product);
        return ResponseEntity.ok(productNew);
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Product>> getByUserId(@PathVariable("userId") int userId) {
        List<Product> products = productService.byUserId(userId);
        return ResponseEntity.ok(products);
    }

}
