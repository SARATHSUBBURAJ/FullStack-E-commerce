package com.youtube.jwt.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String status;
    private int quantity;
    private double totalPrice;

    @ElementCollection
    private List<ProductContent> products;

    public Cart() {}

    public Cart(int quantity, List<ProductContent> products, double totalPrice, String userName, String status) {
        this.quantity = quantity;
        this.products = products;
        this.totalPrice = totalPrice;
        this.userName = userName;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ProductContent> getProducts() {
        return products;
    }

    public void setProducts(List<ProductContent> products) {
        this.products = products;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public List<ProductContent> getProductContent() { return products; }
    public void setProductContent(List<ProductContent> products) { this.products = products; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}

