package com.example.pink_project.usecases;

import com.example.pink_project.contracts.Usecase;
import com.example.pink_project.dtos.CreateProductDto;
import com.example.pink_project.entities.Product;
import com.example.pink_project.exceptions.AppException;
import com.example.pink_project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.UUID;


@Service
public class CreateProductUsecase implements Usecase<CreateProductDto, ResponseEntity<String>> {

    @Autowired
    private ProductRepository repository;

    @Override
    public ResponseEntity<String > execute(CreateProductDto data) throws AppException {

        Product newProduct = new Product(
                    UUID.randomUUID(),
                    data.getName(),
                    data.getAvailable(),
                    data.getDestination(),
                    data.getReturnFee(),
                    data.getMinimumTerm(),
                    data.getAdministrationFee(),
                    data.getDueDate(),
                    data.getDailyLiquidity());


        LocalDate dueDate = data.getDueDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long investmentTime = ChronoUnit.MONTHS.between(LocalDate.now(), dueDate);
        System.out.println(investmentTime);
        if(investmentTime < data.getMinimumTerm()) {
            throw  new AppException("Investment time cannot be less than minimum term", HttpStatus.BAD_REQUEST);
        }

        if(investmentTime == data.getMinimumTerm() && data.getDailyLiquidity()) {
            throw  new AppException("Product cannot have daily liquidity when investment time is equals to minimum term", HttpStatus.BAD_REQUEST);
        }

        repository.save(newProduct);
        return new ResponseEntity<>("Product was successfully created", HttpStatus.CREATED);

    }

}