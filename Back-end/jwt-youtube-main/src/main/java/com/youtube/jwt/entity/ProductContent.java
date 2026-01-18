package com.youtube.jwt.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductContent implements Serializable {

    private Long productId;
    private String productName;
    private int quantity;
    private int amount;

    public ProductContent() {}

    public ProductContent(Long productId, String productName, int quantity, int amount) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }
}
