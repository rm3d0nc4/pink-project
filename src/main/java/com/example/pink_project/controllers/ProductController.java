package com.example.pink_project.controllers;

import com.example.pink_project.contracts.NoParams;
import com.example.pink_project.dtos.*;
import com.example.pink_project.entities.Product;
import com.example.pink_project.exceptions.AppException;
import com.example.pink_project.usecases.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1.")
public class ProductController {

    @Autowired
    private CreateProductUsecase createProductUsecase;
    @Autowired
    private ListAllProductsUsecase listAllProductsUsecase;
    @Autowired
    private GetProductUsecase getProductUsecase;
    @Autowired
    private UpdateProductUsecase updateProductUsecase;
    @Autowired
    private RemoveProductUsecase removeProductUsecase;
    @Autowired
    private ChangeProductStatusUsecase changeProductStatusUsecase;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> listAllProducts() {

        return listAllProductsUsecase.execute(new NoParams());
    }
    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody CreateProductDto dto) throws AppException {
        System.out.println(dto);
        return createProductUsecase.execute(dto);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id")  UUID id) throws AppException {

        return getProductUsecase.execute(new GetProductDto(id));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> removeProduct(@PathVariable(value = "id") UUID id) throws AppException {
        return removeProductUsecase.execute(new RemoveProductDto(id));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable(value = "id") UUID id, @RequestBody UpdateProductDto dto) throws AppException {
        dto.setId(id);
        System.out.println(dto);
        return updateProductUsecase.execute(dto);
    }

    @PatchMapping("/products/{id}/change-status")
    public ResponseEntity<String> changeProductStatus(@PathVariable(value = "id") UUID id) throws AppException {
        return changeProductStatusUsecase.execute(new ChangeProductStatusDto(id));
    }
}
