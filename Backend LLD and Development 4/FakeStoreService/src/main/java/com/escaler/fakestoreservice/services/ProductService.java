package com.escaler.fakestoreservice.services;

import com.escaler.fakestoreservice.dtos.ProductDto;
import org.springframework.web.bind.annotation.*;

public interface ProductService {
    public String getAllProduct();
    public String getSingleProduct( Long productId);
    public String addNewProduct( ProductDto productDto);
    public String updateProduct( Long productId);
    public String deleteProduct( Long productId);
}
