package com.practice.alpha.repository;

import com.practice.alpha.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository{

    List<Product> findAll();

    Product save(Product product);

    Optional<Product> findById(Long productId);

    void deleteById(Long id);
}
