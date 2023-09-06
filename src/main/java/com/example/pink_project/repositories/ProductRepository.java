package com.example.pink_project.repositories;

import com.example.pink_project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;



@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {}