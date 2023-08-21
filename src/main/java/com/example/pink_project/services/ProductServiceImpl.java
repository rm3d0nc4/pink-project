package com.example.pink_project.services;

import com.example.pink_project.dtos.ProductDto;
import com.example.pink_project.entities.Product;
import com.example.pink_project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void createProduct(ProductDto dto) {
        Product product = new Product(
                UUID.randomUUID(),
                dto.getName(),
                dto.isAvailable(),
                dto.getDestination(),
                dto.getReturnRate(),
                dto.getTerm(),
                dto.getAdministrationRate()
        );
        productRepository.save(product);
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void changeStatus(UUID id) {
        Product product = productRepository.findById(id);
        productRepository.updateStatus(id, product);
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
