package com.youtube.jwt.entity;

public class ProductContentDTO {
    private Long productId;
    private String productName;
    private int quantity;
    private int amount;

    // Getters & Setters
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }
}

