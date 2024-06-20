package com.apnadukaan.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDtoViaFakeStore {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;


    @Override
    public String toString() {
        return "ProductDtoViaFakeStore{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
