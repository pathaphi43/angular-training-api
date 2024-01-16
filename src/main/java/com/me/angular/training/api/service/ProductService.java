package com.me.angular.training.api.service;


import com.me.angular.training.api.configuration.ExceptionHandle;
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

    public List<Products> getAll() {
        return productsRepository.findAll();
    }

    public Products getById(long id) {
        return productsRepository.findById(id).orElseThrow(() -> new ExceptionHandle("ไม่พบ Product id: " + id));
    }

    public Products add(Products products) {
        return productsRepository.save(products);
    }

    public Products update(long id, Products products) {
        Products old = getById(id);
        old.setCategory(products.getCategory());
        old.setTitle(products.getTitle());
        old.setPrice(products.getPrice());
        old.setDescription(products.getDescription());
        return productsRepository.save(old);
    }

    public void delete(long id) {
        productsRepository.deleteById(getById(id).getId());
    }
}


