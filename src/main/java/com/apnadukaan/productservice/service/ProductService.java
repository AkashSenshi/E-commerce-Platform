package com.apnadukaan.productservice.service;

import com.apnadukaan.productservice.ExceptionHandler.Exception.ProductNotFoundException;
import com.apnadukaan.productservice.model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product addProduct(Product product);
    Product updateProduct(Product product);
    Product replaceProduct(Product product);
    void removeProductById(Long id);
}
