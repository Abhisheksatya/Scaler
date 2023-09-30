package com.escaler.fakestoreservice.services;

import org.springframework.web.bind.annotation.PathVariable;

public interface CategoryService {
    String getAllCategories();
    String getProductsInCategory(Long categoryId);
}
