package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Lazy
@Service
@ConditionalOnProperty(name = "product.service", havingValue = "json")
public class ProductServiceJSONImpl implements ProductService {

    @Override
    public List<Product> getProducts() {
        List<Product> products;
        try {
            products = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/products.json"),
                            new TypeReference<List<Product>>() {
                            });

            return products;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
