package com.youtube.jwt.service;

import com.youtube.jwt.dao.ProductDao;
import com.youtube.jwt.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    public Page<Products> getProducts(int page, int size, String search) {

        Pageable pageable = PageRequest.of(page, size);

        Specification<Products> spec = buildSearchSpecification(search);

        return productDao.findAll(spec, pageable);
    }


    public static Specification<Products> buildSearchSpecification(String searchText) {

        return (root, query, criteriaBuilder) -> {

            // 1. If search text is empty → return all products (no filtering)
            if (searchText == null || searchText.trim().isEmpty()) {
                return criteriaBuilder.conjunction();
            }

            // 2. Prepare search text for LIKE query (case-insensitive)
            String formattedSearchText = "%" + searchText.toLowerCase() + "%";

            // 3. Create OR conditions for each searchable field
            return criteriaBuilder.or(
                    fieldContains(criteriaBuilder, root.get("productName"), formattedSearchText),
                    fieldContains(criteriaBuilder, root.get("categoryName"), formattedSearchText)
            );
        };
    }

    private static javax.persistence.criteria.Predicate fieldContains(
            javax.persistence.criteria.CriteriaBuilder criteriaBuilder,
            javax.persistence.criteria.Expression<String> productField,
            String formattedSearchText) {

        return criteriaBuilder.like(
                criteriaBuilder.lower(productField),
                formattedSearchText
        );
    }

    public Products getProductById(Long id) {
        return productDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));
    }
}
