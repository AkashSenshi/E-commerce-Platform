package com.apnadukaan.productservice.ExceptionHandler;

import com.apnadukaan.productservice.ExceptionHandler.Exceptions.ProductNotFoundException;
import com.apnadukaan.productservice.ExceptionHandler.dtos.ProductNotFoundDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlers {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundDto> handleProductNotFoundException(){
        ProductNotFoundDto productNotFound = new ProductNotFoundDto();
        productNotFound.setMessage("Product Not Found");
        return new ResponseEntity<>(productNotFound, HttpStatus.BAD_REQUEST);
    }
}
