package com.example.pink_project.usecases;

import com.example.pink_project.contracts.Usecase;
import com.example.pink_project.dtos.ChangeProductStatusDto;
import com.example.pink_project.entities.Product;
import com.example.pink_project.exceptions.AppException;
import com.example.pink_project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ChangeProductStatusUsecase implements Usecase<ChangeProductStatusDto, ResponseEntity<String>>  {

    @Autowired
    private ProductRepository repository;

    @Override
    public ResponseEntity<String> execute(ChangeProductStatusDto data) throws AppException {
        Optional<Product> productOptional = repository.findById(data.getId());
        if(productOptional.isEmpty()) {
            throw  new AppException("Product not found", HttpStatus.NOT_FOUND);
        }
        Product product = productOptional.get();
        product.setAvailable(!product.getAvailable());
        repository.save(product);
        return  new ResponseEntity<String>("Product status was successfully changed", HttpStatus.OK);
    }
}
