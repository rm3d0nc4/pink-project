package com.example.pink_project.repositories;

import com.example.pink_project.entities.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> fetchAllProducts();
    public void createProduct(Product product);
    public void updateProduct(String id, Product product);
    public void deleteProduct(String id);
}
