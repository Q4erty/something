package com.practice.alpha.repository;

import com.practice.alpha.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryProductsDataBase implements ProductRepository {

    private final List<Product> products = Collections.synchronizedList(new LinkedList<>());

    @Override
    public List<Product> findAll() {
        return Collections.unmodifiableList(this.products);
    }

    @Override
    public Product save(Product product) {
        product.setId(this.products.stream()
                .max(Comparator.comparingLong(Product::getId))
                .map(Product::getId)
                .orElse(0L) + 1);
        this.products.add(product);
        return product;
    }

    @Override
    public Optional<Product> findById(Long productId) {
        return this.products.stream()
                .filter(product -> Objects.equals(productId, product.getId()))
                .findFirst();
    }

    @Override
    public void deleteById(Long id) {
        this.products.removeIf(product -> Objects.equals(id, product.getId()));
    }
}
