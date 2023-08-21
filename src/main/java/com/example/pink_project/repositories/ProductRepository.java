package com.example.pink_project.repositories;

import com.example.pink_project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;



@Repository
public interface ProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(UUID id);

    void updateStatus(UUID id, Product product);

    void deleteById(UUID id);
}