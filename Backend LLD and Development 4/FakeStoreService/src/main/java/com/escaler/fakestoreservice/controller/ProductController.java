package com.escaler.fakestoreservice.controller;

import com.escaler.fakestoreservice.dtos.GetSingleProductResponseDto;
import com.escaler.fakestoreservice.dtos.ProductDto;
import com.escaler.fakestoreservice.model.Product;
import com.escaler.fakestoreservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

//    @GetMapping("/{productId}")
//    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId){
//        ResponseEntity<Product> response=new ResponseEntity<>(productService.getSingleProduct(productId), HttpStatus.OK);
//        return response; //just change the status code of response
//    }
    @GetMapping("/{productId}")
    public GetSingleProductResponseDto getSingleProduct(@PathVariable("productId") Long productId){
        GetSingleProductResponseDto responseDto = new GetSingleProductResponseDto();
        responseDto.setProduct(productService.getSingleProduct(productId));
        return responseDto;
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
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto product){
        Product response = productService.addNewProduct(product);
        ResponseEntity<Product> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
        return responseEntity;
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
