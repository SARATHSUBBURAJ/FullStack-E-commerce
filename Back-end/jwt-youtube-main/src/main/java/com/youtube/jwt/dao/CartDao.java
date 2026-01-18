package com.youtube.jwt.dao;

import com.youtube.jwt.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDao extends JpaRepository<Cart, Long> {
    List<Cart> findByUserName(String userName);
}
