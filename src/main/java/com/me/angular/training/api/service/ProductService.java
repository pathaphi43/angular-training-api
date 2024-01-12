package com.me.angular.training.api.service;


import com.me.angular.training.api.entities.Products;
import com.me.angular.training.api.repositories.ProductsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductsRepository productsRepository;

    public List<Products> getAllProduct() {
        return productsRepository.findAll();
    }

    public Products addProduct(Products products) {
        return productsRepository.save(products);
    }

    public Products updateProduct(long id, Products products) {
        Products old = productsRepository.findById(id).orElseThrow(() -> new RuntimeException("ไม่พบ ID: "+id));
        old.setCategory(products.getCategory());
        old.setTitle(products.getTitle());
        old.setPrice(products.getPrice());
        old.setDescription(products.getDescription());
        return productsRepository.save(old);
    }

    public void deleteProduct(long id) {
        Products old = productsRepository.findById(id).orElseThrow(() -> new RuntimeException("ไม่พบ ID: "+id));
        productsRepository.deleteById(old.getId());
    }
}


