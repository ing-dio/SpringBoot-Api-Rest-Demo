package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Product;

@Service
@ConditionalOnProperty(name = "product.service", havingValue = "list")
public class ProductServiceImpl implements ProductService {
    List<Product> products = new ArrayList<>(Arrays.asList(
        new Product(1, "Product 1", 100.0, 10),
        new Product(2, "Product 2", 200.0, 20),
        new Product(3, "Product 3", 300.0, 30),
        new Product(4, "Product 4", 400.0, 40)
    ));

    @Override
    public List<Product> getProducts(){
        return products;
    }
}
