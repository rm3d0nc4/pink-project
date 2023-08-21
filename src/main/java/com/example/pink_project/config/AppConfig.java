package com.example.pink_project.config;

import com.example.pink_project.repositories.ProductRepository;
import com.example.pink_project.repositories.ProductRepositoryImpl;
import com.example.pink_project.services.ProductService;
import com.example.pink_project.services.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "productRepository")
    public  ProductRepository getProductRepository() {
        return new ProductRepositoryImpl();
    }

    @Bean(name = "productService")
    public ProductService getProductService(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }
}
