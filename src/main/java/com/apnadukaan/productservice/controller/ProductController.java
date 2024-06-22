package com.apnadukaan.productservice.controller;

import com.apnadukaan.productservice.ExceptionHandler.Exceptions.ProductNotFoundException;
import com.apnadukaan.productservice.model.Product;
import com.apnadukaan.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    ProductController(@Qualifier("ProductServiceViaSelf")ProductService productServicegi) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws ProductNotFoundException {
        ResponseEntity<Product> response = null;
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("")
    public List<Product> getAllProduct() throws ProductNotFoundException {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product)  {
        ResponseEntity<Product> response = null;
        product.setId(id);
        Product newProduct = productService.updateProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }

}
