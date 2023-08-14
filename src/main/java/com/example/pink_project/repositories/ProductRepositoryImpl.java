package com.example.pink_project.repositories;

import com.example.pink_project.entities.Product;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.List;

public class ProductRepositoryImpl implements  ProductRepository{
    private final HashMap<String, Product> products = new HashMap<String, Product>(
    );
    @Override
    public List<Product> fetchAllProducts() {
        this.products.putIfAbsent("one", new Product( 1,"Investimento 01", true, "Investimento para comprar um BMW 750LI", 10, 12, 5.0));
        this.products.putIfAbsent("two", new Product( 2,"Investimento 01", false, "Investimento para comprar uma Mansão em Miami", 20, 5, 0.30));
        return this.products.values().stream().toList();
    }

    @Override
    public void createProduct(Product product) {
        String id =  String.valueOf(product.getId());
        products.put(id, product);
    }

    public void updateProduct(String id, Product product) {
        products.replace(id, product);
    }

    @Override
    public void deleteProduct(String id) {
        Product product = this.products.remove(id);
    }
}
