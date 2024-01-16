package com.me.angular.training.api.controllers;

import com.me.angular.training.api.entities.Products;
import com.me.angular.training.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
@Slf4j
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<String> getProduct() {
        return ResponseEntity.ok("product");
    }

    @GetMapping("{id}")
    public ResponseEntity<Products> getProductById(@PathVariable() long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping("all")
    public ResponseEntity<List<Products>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<Products> addProduct(@RequestBody Products products) {
        return ResponseEntity.ok(productService.add(products));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable() long id, @RequestBody Products products) {
        return ResponseEntity.ok(productService.update(id, products));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable() long id) {
        productService.delete(id);
        return ResponseEntity.ok(Map.of("message", "success"));
    }
}
