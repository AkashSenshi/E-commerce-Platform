package com.apnadukaan.productservice.ExceptionHandler.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductNotFoundException extends Exception{
    private Long id;
    private String message;
}
