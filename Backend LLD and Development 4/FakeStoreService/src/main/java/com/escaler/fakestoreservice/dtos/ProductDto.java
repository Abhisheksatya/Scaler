package com.escaler.fakestoreservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String title;
    private double price;
    private String description;
    private String imageUrl;
    private String category;
}
