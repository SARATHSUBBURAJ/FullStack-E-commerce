package com.youtube.jwt.dao;

import com.youtube.jwt.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductDao extends JpaRepository<Products, Long>, JpaSpecificationExecutor<Products> {
}
