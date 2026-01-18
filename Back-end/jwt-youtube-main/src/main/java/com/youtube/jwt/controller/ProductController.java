package com.youtube.jwt.controller;

import com.youtube.jwt.dao.ProductDao;
import com.youtube.jwt.entity.Products;
import com.youtube.jwt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@CrossOrigin


public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProducts")
    public Page<Products> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String search) {

        return productService.getProducts(page, size, search);
    }

    @GetMapping("/getProductById/{id}")
    public Products getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }
}
