package com.example.pink_project.config;

import com.example.pink_project.repositories.ProductRepository;
import com.example.pink_project.repositories.ProductRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "myProductRepository")
    public ProductRepository getProductRepository() {
        return new ProductRepositoryImpl();
    }
}
