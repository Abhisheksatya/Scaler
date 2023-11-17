package com.escaler.fakestoreservice.services;

import com.escaler.fakestoreservice.dtos.FakeStoreProductDto;
import com.escaler.fakestoreservice.dtos.ProductDto;
import com.escaler.fakestoreservice.model.Category;
import com.escaler.fakestoreservice.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    public ProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    @Override
    public List<Product> getAllProduct() {
        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<List> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products",List.class);
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products",FakeStoreProductDto[].class);
        List<Product> response = new ArrayList<>();
//        for(Object object: responseEntity.getBody()){
//            HashMap<String,Object> hashMap = (HashMap<String, Object>) object;
//
//            Product product=new Product();
//            product.setId(Long.valueOf((Integer)hashMap.get("id")));
//            product.setTitle((String) hashMap.get("title"));
//            product.setPrice(Double.valueOf(hashMap.get("price").toString()));
//            product.setImageUrl((String) hashMap.get("image"));
//            Category category=new Category();
//            category.setName((String) hashMap.get("category"));
//            product.setCategory(category);
//            response.add(product);
//        }
        for(FakeStoreProductDto productDto: Objects.requireNonNull(responseEntity.getBody())){
            response.add(convertFakeStoreProductDtoToProduct(productDto));
        }
        return response;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity= restTemplate.getForEntity("https://fakestoreapi.com/products/{productId}",FakeStoreProductDto.class,productId);
//        if(responseEntity.getStatusCode().is2xxSuccessful())
        return convertFakeStoreProductDtoToProduct(Objects.requireNonNull(responseEntity.getBody()));
    }

    @Override
    public Product addNewProduct(ProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity("https://fakestoreapi.com/products",product,FakeStoreProductDto.class);
        return convertFakeStoreProductDtoToProduct(responseEntity.getBody());
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto productDto) {
        Product product=new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImage());
        Category category=new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }
}
