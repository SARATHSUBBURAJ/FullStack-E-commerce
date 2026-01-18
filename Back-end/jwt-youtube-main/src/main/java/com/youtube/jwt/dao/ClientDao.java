package com.youtube.jwt.dao;

import com.youtube.jwt.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Products, Long> {
}
