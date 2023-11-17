package com.escaler.fakestoreservice.model;

import java.util.List;

public class Category extends BaseModel {
    private String name;
    private String description;
    private List<Product> products;

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
