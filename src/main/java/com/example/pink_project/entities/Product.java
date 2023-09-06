package com.example.pink_project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "product",schema = "public")
public class Product {
    @Id
    @NotNull
    @Column(name = "id")
    private UUID id;
    @NotNull(message = "Name cannot be null")
    @Size(max = 32, message = "Name cannot contain more than 32 characters")
    @Column(name = "name", length = 32)
    private String name;
    @NotNull(message = "Status cannot be null")
    @Column(name = "available")
    private  Boolean available;
    @NotNull(message = "Destination cannot be null")
    @Column(name = "destination", length = 180)
    @Size(max = 180, message = "Destination cannot contain more than 180 characters")
    private  String destination;
    @NotNull(message = "Return fee cannot be null")
    @Column(name = "return_fee")
    @Min(value = 1, message = "Return fee must be greater than or equal to 1 and less than or equal to 20")
    @Max(value = 20, message = "Return fee must be greater than or equal to 1 and less than or equal to 20")
    private Integer returnFee;
    @NotNull(message = "Return fee cannot be null")
    @Column(name = "minimum_term")
    @Min(value = 0, message = "Minimum term must be greater than or equal to 0 and less than or equal to 48")
    @Max(value = 48, message = "Minimum term must be greater than or equal to 0 and less than or equal to 48")
    private Integer minimumTerm;
    @NotNull(message = "Administration fee term cannot be null")
    @PositiveOrZero(message = "Administration fee must be greater than or equal to 0")
    @Column(name = "administration_fee")
    private Double administrationFee;
    @NotNull(message = "Due date cannot be null")
    @Column(name = "due_date")
    private Date dueDate;
    @NotNull(message = "Daily liquidity cannot be null")
    @Column(name = "daily_liquidity")
    private Boolean dailyLiquidity;


    public Product() {}

    public Product(
            UUID id,
            String name,
            Boolean available,
            String destination,
            Integer returnFee,
            Integer minimumTerm,
            Double administrationFee,
            Date dueDate,
            Boolean dailyLiquidity) {
        this.id = id;
        this.name = name;
        this.available = available;
        this.destination = destination;
        this.returnFee = returnFee;
        this.minimumTerm = minimumTerm;
        this.administrationFee = administrationFee;
        this.dueDate = dueDate;
        this.dailyLiquidity = dailyLiquidity;
    }

}
