package com.youtube.jwt.service;


import com.youtube.jwt.Exception.InsufficientStockException;
import com.youtube.jwt.dao.CartDao;
import com.youtube.jwt.dao.ProductDao;
import com.youtube.jwt.entity.Cart;
import com.youtube.jwt.entity.ProductContent;
import com.youtube.jwt.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    CartDao cartDao;

    @Autowired
    ProductDao productDao;

    public List<Cart> getMyCart(String userName) {
        return cartDao.findByUserName(userName);
    }


    public Cart addCart(Cart cart) {
        return cartDao.save(cart);
    }

    @Transactional
    public Cart finalizeProduct(Cart cart) {

        if (cart.getProductContent() == null || cart.getProductContent().isEmpty()) {
            throw new RuntimeException("Cart has no products");
        }

        double totalPrice = 0;
        int totalQuantity = 0;

        for (ProductContent pc : cart.getProductContent()) {
            Products product = productDao.findById(pc.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found: " + pc.getProductId()));

            if (product.getQuantity() < pc.getQuantity()) {
                throw new RuntimeException("Not enough stock for product: " + product.getProductName());
            }

            product.setQuantity(product.getQuantity() - pc.getQuantity());
            if (product.getQuantity() == 0) product.setStatus("NOT_AVAILABLE");

            productDao.save(product);

            totalPrice += pc.getQuantity() * pc.getAmount();
            totalQuantity += pc.getQuantity();
        }

        cart.setStatus("ORDERED");
        cart.setTotalPrice(totalPrice);
        cart.setQuantity(totalQuantity);

        return cartDao.save(cart);
    }






    public Cart addProductsByCartId(Cart cartRequest, Long cartId) {
        Cart existingCart = cartDao.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found with ID: " + cartId));
        if (cartRequest.getProductContent() != null && !cartRequest.getProductContent().isEmpty()) {
            existingCart.getProductContent().addAll(cartRequest.getProductContent());
        }
        existingCart.setQuantity(existingCart.getQuantity() + cartRequest.getQuantity());
        existingCart.setTotalPrice(existingCart.getTotalPrice() + cartRequest.getTotalPrice());
        return cartDao.save(existingCart);
    }
}
