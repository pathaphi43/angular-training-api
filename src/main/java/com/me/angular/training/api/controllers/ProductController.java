package com.me.angular.training.api.controllers;

import com.me.angular.training.api.entities.Products;
import com.me.angular.training.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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

    @GetMapping("all")
    public ResponseEntity<List<Products>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @PostMapping("add")
    public ResponseEntity<Products> addProduct(@RequestBody Products products) {
        return ResponseEntity.ok(productService.addProduct(products));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable() long id, @RequestBody Products products) {
        return ResponseEntity.ok(productService.updateProduct(id,products));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable() long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("success");
    }
}
