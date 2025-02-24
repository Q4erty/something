package com.practice.alpha.controller;

import com.practice.alpha.service.ProductService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductsControllerTest {

    @Mock
    ProductService productService;

    @InjectMocks
    ProductsController controller;

    
}