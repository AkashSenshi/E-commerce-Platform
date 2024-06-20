package com.apnadukaan.productservice.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product extends Category {
    private String title;
    private double price;
    private Category category;
    private String description;
    private String imageUrl;

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
