package com.example.pink_project.usecases;

import com.example.pink_project.contracts.NoParams;
import com.example.pink_project.contracts.Usecase;
import com.example.pink_project.dtos.CreateProductDto;
import com.example.pink_project.entities.Product;
import com.example.pink_project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllProductsUsecase implements Usecase<NoParams, ResponseEntity<List<Product>>> {

    @Autowired
    private ProductRepository repository;
    @Override
    public ResponseEntity<List<Product>> execute(NoParams data) {
        List<Product> products = repository.findAll();

        return  new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }


}
