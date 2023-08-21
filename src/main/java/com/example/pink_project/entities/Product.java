package com.example.pink_project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "product",schema = "public")
public class Product {
    @Id @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "available")
    private  boolean available;
    @Column(name = "destination")
    private  String destination;
    @Column(name = "return_rate")
    private int returnRate;
    @Column(name = "term")
    private int term;
    @Column(name = "administration_rate")
    private double administrationRate;

    public Product() {}

    public Product(UUID id, String name, boolean available, String destination, int returnRate, int term, double administrationRate) {
        this.id = id;
        this.name = name;
        this.available = available;
        this.destination = destination;
        this.returnRate = returnRate;
        this.term = term;
        this.administrationRate = administrationRate;
    }
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
