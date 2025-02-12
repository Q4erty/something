package com.practice.alpha.controller;

import com.practice.alpha.dto.NewProductDTO;
import com.practice.alpha.entity.Product;
import com.practice.alpha.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductsController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return this.productService.findAllProducts();
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@Valid @RequestBody NewProductDTO newProductDTO,
                                        BindingResult bindingResult,
                                        UriComponentsBuilder uriBuilder) throws BindException {
        if (bindingResult.hasErrors()) {
            if(bindingResult instanceof BindException exception) {
                throw exception;
            } else {
                throw new BindException(bindingResult);
            }
        } else {
            Product product = this.productService.createProduct(newProductDTO.title(), newProductDTO.details());
            return ResponseEntity
                    .created(uriBuilder
                            .replacePath("api/products/{productId}")
                            .build(Map.of("productId", product.getId())))
                    .body(product);
        }
    }
}
