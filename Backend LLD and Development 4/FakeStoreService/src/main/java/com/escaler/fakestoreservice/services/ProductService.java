package com.escaler.fakestoreservice.services;

import com.escaler.fakestoreservice.dtos.ProductDto;
import com.escaler.fakestoreservice.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    Product getSingleProduct( Long productId);
    Product addNewProduct(ProductDto product);
    Product updateProduct( Long productId,Product product);
    boolean  deleteProduct( Long productId);
}
