package com.youtube.jwt.controller;

import com.youtube.jwt.dao.CartDao;
import com.youtube.jwt.dao.UserDao;
import com.youtube.jwt.entity.Cart;
import com.youtube.jwt.service.ClientService;
import com.youtube.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class ClientController {

    @Autowired
    CartDao cartDao;

    @Autowired
    ClientService clientService;

    @GetMapping("/getMyCart/{userName}")
    @PreAuthorize("hasRole('User')")
    public List<Cart> getMyCart( @PathVariable("userName") String userName) {
        return clientService.getMyCart(userName);
    }

    @PostMapping("/myCart")
    @PreAuthorize("hasRole('User')")
    public Cart addMyCart(@RequestBody Cart cart) {
        return clientService.addCart(cart);
    }

    @PostMapping("/myCart/{cartId}")
    @PreAuthorize("hasRole('User')")
    public Cart addMyCart(@RequestBody Cart cart, @PathVariable Long cartId) {
        return clientService.addProductsByCartId(cart, cartId);
    }

    @PostMapping("/myCart/finalizeProduct")
    @PreAuthorize("hasRole('User')")
    public Cart finalizeProduct(@RequestBody Cart cart) {
        System.out.println("Received Cart: " + cart);
        return clientService.finalizeProduct(cart);
    }

}
