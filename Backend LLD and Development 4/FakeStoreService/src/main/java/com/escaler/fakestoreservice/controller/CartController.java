package com.escaler.fakestoreservice.controller;

import com.escaler.fakestoreservice.dtos.CartDto;
import com.escaler.fakestoreservice.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/carts")
public class CartController {
    @GetMapping()
    public String getAllCarts(){
        return "Return All carts";
    }
    @GetMapping("/{cartId}")
    public String getProductsInCategory(@PathVariable("cartId")Long cartId){
        return "Return a Single cart : " +cartId;
    }
    @GetMapping("/limited")
    public String getLimitedCart(@RequestParam(name = "limit") Long limit){
        return "return Limited Cart "+limit;
    }
    @GetMapping("/sort")
    public String getSortedCart(@RequestParam("sortType") String sortType){
        return "return Sorted Cart with Sort Type : "+sortType;
    }
    @GetMapping("/dates")
    public String getSortedCartInDateRange(@RequestParam("startdate") Date startdate,@RequestParam("enddate") Date enddate){
        return "return Sorted Cart with Sort Date : "+startdate + " "+ enddate;
    }
    @GetMapping("/user/{userId}")
    public String getUserCart(@PathVariable("userId") Long userId){
        return "return Cart of User ID : "+userId ;
    }
    @PostMapping
    public String addCart(@RequestBody CartDto cartDto){
        return "add cart : "+cartDto ;
    }
    @PutMapping("/cartId")
    public String updateCart(@PathVariable(name = "cartId") Long cartId,@RequestBody CartDto cartDto){
        return "Update cart od id  : "+cartId +" and dto is "+cartDto ;
    }
    @DeleteMapping("/{cartId}")
    public String deleteCart(@PathVariable Long cartId ){
        return "delete cart : "+cartId ;
    }
}
