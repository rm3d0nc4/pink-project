package com.example.pink_project.usecases;

import com.example.pink_project.contracts.Usecase;
import com.example.pink_project.dtos.GetProductDto;
import com.example.pink_project.entities.Product;
import com.example.pink_project.exceptions.AppException;
import com.example.pink_project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductUsecase implements Usecase<GetProductDto, ResponseEntity<Product>> {


    @Autowired
    private ProductRepository repository;

    @Override
    public ResponseEntity<Product> execute(GetProductDto data) throws AppException {
        Optional<Product> product = repository.findById(data.getId());
        if(product.isEmpty()) {
            throw  new AppException("Product not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
    }
}
