package com.example.pink_project.services;

import com.example.pink_project.dtos.ProductDto;
import com.example.pink_project.entities.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public void createProduct(ProductDto dto);
    public List<Product> listAllProducts();
    public  void changeStatus(UUID id);
    public void deleteProduct(UUID id);
}
