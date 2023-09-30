package com.escaler.fakestoreservice.dtos;

import com.escaler.fakestoreservice.model.CartProduct;
import com.escaler.fakestoreservice.model.Product;

import java.util.Date;
import java.util.List;

public class CartDto {

    private double UserId;
    private Date date;
    private List<CartProduct> products;
}
