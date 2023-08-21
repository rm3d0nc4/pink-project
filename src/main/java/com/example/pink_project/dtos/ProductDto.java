package com.example.pink_project.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String name;
    private boolean available;
    private String destination;
    private int returnRate;
    private int term;
    private double administrationRate;

    public ProductDto(String name, boolean available, String destination, int returnRate, int term, double administrationRate) {
        this.name = name;
        this.available = available;
        this.destination = destination;
        this.returnRate = returnRate;
        this.term = term;
        this.administrationRate = administrationRate;
    }

    public ProductDto() {

    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "name='" + name + '\'' +
                ", available=" + available +
                ", destination='" + destination + '\'' +
                ", returnRate=" + returnRate +
                ", term=" + term +
                ", administrationRate=" + administrationRate +
                '}';
    }
}
