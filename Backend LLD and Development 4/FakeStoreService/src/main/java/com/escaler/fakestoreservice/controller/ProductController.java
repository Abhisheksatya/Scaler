package com.escaler.fakestoreservice.controller;

import com.escaler.fakestoreservice.dtos.ProductDto;
import com.escaler.fakestoreservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProduct(){
        return "return All Products";
    }
    @GetMapping("/{productId}")
    public String getSingleProduct(@PathVariable("productId") Long productId){
        return "return Single Product with id : "+productId;
    }
    @GetMapping("/limited")
    public String getLimitedProduct(@RequestParam(name = "limit") Long limit){
        return "return Limited Product "+limit;
    }
    @GetMapping("/sort")
    public String getSortedProduct(@RequestParam("sortType") String sortType){
        return "return Sorted Product with Sort Type : "+sortType;
    }
    @PostMapping
    public String addNewProduct(@RequestBody ProductDto productDto){
        return "Add Product" +productDto;
    }
    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId,@RequestBody ProductDto productDto){
        return "Update Product which having ID :"+productId;
    }
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return "delete product with id :" +productId;
    }
}
