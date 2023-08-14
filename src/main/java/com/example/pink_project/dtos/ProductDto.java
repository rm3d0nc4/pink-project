package com.example.pink_project.dtos;


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

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getDestination() {
        return destination;
    }

    public int getReturnRate() {
        return returnRate;
    }

    public int getTerm() {
        return term;
    }

    public double getAdministrationRate() {
        return administrationRate;
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
