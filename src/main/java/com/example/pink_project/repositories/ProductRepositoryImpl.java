package com.example.pink_project.repositories;

import com.example.pink_project.entities.Product;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ProductRepositoryImpl implements  ProductRepository{
    private final HashMap<UUID, Product> products = new HashMap<UUID, Product>();
    @Override
    public List<Product> findAll() {
        List<Product> products = this.products.values().stream().toList();
        return products;
    }

    @Override
    public Product findById(UUID id) {
        return  this.products.get(id);
    }


    @Override
    public void save(Product product) {
        UUID id = product.getId();
        products.put(id, product);
    }

    @Override
    public void updateStatus(UUID id, Product product) {
        product.setAvailable(!product.isAvailable());
        products.replace(id, product);
    }

    @Override
    public void deleteById(UUID id) {
        Product product = this.products.remove(id);
    }
}
