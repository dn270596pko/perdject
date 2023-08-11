package com.olegkirillovich.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double percentage;

    @OneToMany(mappedBy = "discount")
    private Set<Product> products = new HashSet<>();

    public Discount() {
    }

    public Discount(String name, double percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
