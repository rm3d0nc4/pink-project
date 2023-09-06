package com.example.pink_project.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class CreateProductDto {
    private String name;
    private Boolean available;
    private String destination;
    private Integer returnFee;
    private Integer minimumTerm;
    private Double administrationFee;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;
    private Boolean dailyLiquidity;

    public CreateProductDto(String name, Boolean available, String destination, Integer returnFee, Integer minimumTerm, Double administrationFee, Date dueDate, Boolean dailyLiquidity) {
        this.name = name;
        this.available = available;
        this.destination = destination;
        this.returnFee = returnFee;
        this.minimumTerm = minimumTerm;
        this.administrationFee = administrationFee;
        this.dueDate = dueDate;
        this.dailyLiquidity = dailyLiquidity;
    }

    public CreateProductDto() {}
}
