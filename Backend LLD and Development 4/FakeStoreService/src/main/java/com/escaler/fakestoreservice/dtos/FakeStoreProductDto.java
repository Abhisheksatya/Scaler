package com.escaler.fakestoreservice.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
    private RatingDto rating;
}
