package com.escaler.fakestoreservice.dtos;

import com.escaler.fakestoreservice.model.Category;
import com.escaler.fakestoreservice.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSingleProductResponseDto {
    private Product product;
}
