package com.example.pink_project.controllers;

import com.example.pink_project.contracts.NoParams;
import com.example.pink_project.dtos.*;
import com.example.pink_project.entities.Product;
import com.example.pink_project.exceptions.AppException;
import com.example.pink_project.usecases.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
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


    @Operation(summary = "List all products")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Return products list",
                    content = @Content(array = @ArraySchema( schema = @Schema(implementation = Product.class)), mediaType = "application/json")),
    })
    @GetMapping("/products")
    public ResponseEntity<List<Product>> listAllProducts() {

        return listAllProductsUsecase.execute(new NoParams());
    }



@Operation(description = "Create new product object", summary = "Create new product object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operation successfully", content = @Content(schema = @Schema(implementation = String.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Incompleted attributes", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json")),
    })
    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody CreateProductDto dto) throws AppException {
        System.out.println(dto);
        return createProductUsecase.execute(dto);
    }


    @Operation(description = "Get product by id", summary = "Get product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product is returned", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json")),
    })
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id")  UUID id) throws AppException {

        return getProductUsecase.execute(new GetProductDto(id));
    }


    @Operation(description = "Get product by id", summary = "Delete product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product was successfully deleted", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json")),
    })
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> removeProduct(@PathVariable(value = "id") UUID id) throws AppException {
        return removeProductUsecase.execute(new RemoveProductDto(id));
    }

    @Operation(description = "Update product by id", summary = "Update product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product was successfully updated", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json")),
    })

    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable(value = "id") UUID id, @RequestBody UpdateProductDto dto) throws AppException {
        dto.setId(id);
        System.out.println(dto);
        return updateProductUsecase.execute(dto);
    }


    @Operation(description = "Update product by id", summary = "Update product status by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product status was successfully updated", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json")),
    })
    @PatchMapping("/products/{id}/change-status")
    public ResponseEntity<String> changeProductStatus(@PathVariable(value = "id") UUID id) throws AppException {
        return changeProductStatusUsecase.execute(new ChangeProductStatusDto(id));
    }
}
