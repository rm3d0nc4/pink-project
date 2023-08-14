package com.example.pink_project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Product {
    @Id
    private long id;
    private String name;
    private  boolean available;
    private  String destination;
    private int returnRate;
    private int term;
    private double administrationRate;

    public Product() {}

    public Product(long id, String name, boolean available, String destination, int returnRate, int term, double administrationRate) {
        this.id = id;
        this.name = name;
        this.available = available;
        this.destination = destination;
        this.returnRate = returnRate;
        this.term = term;
        this.administrationRate = administrationRate;
    }

    public String name() {return name;}
    public boolean available() {return available;}
    public String destination() { return destination;}
    public int returnRate() {return returnRate;}
    public int term() {return term;}
    public double administrationRate() {return administrationRate;}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                ", destination='" + destination + '\'' +
                ", returnRate=" + returnRate +
                ", term=" + term +
                ", administrationRate=" + administrationRate +
                '}';
    }

}
