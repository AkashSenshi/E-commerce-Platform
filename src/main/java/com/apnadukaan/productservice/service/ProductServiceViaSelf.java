package com.apnadukaan.productservice.service;

import com.apnadukaan.productservice.ExceptionHandler.Exceptions.ProductNotFoundException;
import com.apnadukaan.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductServiceViaSelf")
public class ProductServiceViaSelf implements ProductService{
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Product product) {
        return null;
    }

    @Override
    public void removeProductById(Long id) {

    }
}
