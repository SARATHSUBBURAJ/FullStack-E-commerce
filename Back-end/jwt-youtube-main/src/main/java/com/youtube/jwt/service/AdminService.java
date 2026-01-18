package com.youtube.jwt.service;

import com.youtube.jwt.dao.AdminDao;
import com.youtube.jwt.dao.CartDao;
import com.youtube.jwt.dao.ProductDao;
import com.youtube.jwt.entity.Cart;
import com.youtube.jwt.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CartDao cartDao;

    public List<Products> addProducts(List<Products> products){
        return productDao.saveAll(products);
    }

    public List<Products> deleteProducts(Long productId){
        productDao.deleteById(productId);
        return productDao.findAll();
    }

    public Products editProducts(Products products, Long productId) {

        Products existing = productDao.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));

        existing.setProductName(products.getProductName());
        existing.setProductDescription(products.getProductDescription());
        existing.setCategoryName(products.getCategoryName());
        existing.setAmount(products.getAmount());
        existing.setQuantity(products.getQuantity());
        existing.setStatus(products.getStatus());

        return productDao.save(existing);
    }

    public Cart cartStatusUpdate(Long cartId, String status) {
        Cart cart =  cartDao.findById(cartId).orElseThrow(() -> new RuntimeException("Product not found: " + cartId));
        cart.setStatus(status);
        return cartDao.save(cart);
    }

    public List<Cart> getAllCarts() {
        return cartDao.findAll();
    }
}
