package com.escaler.fakestoreservice.controller;

import com.escaler.fakestoreservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public String getAllCategories(){
        return "Return All Categories";
    }
    @GetMapping("/{categoryType}")
    public String getProductsInCategory(@PathVariable("categoryType")Long categoryType){
        return "Return Products In Category with categoryType : " +categoryType;
    }
}
