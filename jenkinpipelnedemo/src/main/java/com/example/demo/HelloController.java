package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class HelloController {

    @Autowired
    private ProductRepository productRepository;

    // POST /products - save a new product
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product saved = productRepository.save(product);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // GET /products - fetch all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // GET /products/{id} - fetch one product
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}