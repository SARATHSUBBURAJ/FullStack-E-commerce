package com.youtube.jwt.controller;

import com.youtube.jwt.entity.Cart;
import com.youtube.jwt.entity.Products;
import com.youtube.jwt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/addProduct")
    @PreAuthorize("hasRole('Admin')")
    public List<Products> addProduct(@RequestBody List<Products> products) {
        return adminService.addProducts(products);
    }

    @PostMapping("/editProduct/{productId}")
    @PreAuthorize("hasRole('Admin')")
    public Products editProduct(@RequestBody Products products,
                                      @PathVariable("productId") Long productId) {
        return adminService.editProducts(products, productId);
    }
    @DeleteMapping("/deleteProduct/{productId}")
    @PreAuthorize("hasRole('Admin')")
    public List<Products> deleteProduct(@PathVariable("productId") Long productId) {
        return adminService.deleteProducts(productId);
    }
    @PostMapping("/carts/editCartStatus/{cartId}/{status}")
    @PreAuthorize("hasRole('Admin')")
    public Cart cartStatusUpdate(@PathVariable("cartId") Long  cartId, @PathVariable("status") String status) {
        return adminService.cartStatusUpdate(cartId, status);
    }

    @GetMapping("/carts/getAllCarts")
    @PreAuthorize("hasRole('Admin')")
    public List<Cart> getAllCarts() {
        return adminService.getAllCarts();
    }
}

