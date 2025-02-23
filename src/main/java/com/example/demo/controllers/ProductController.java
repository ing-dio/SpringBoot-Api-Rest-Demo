package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Configurations.ExternalizedConfigurations;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ExternalizedConfigurations externalizedConfigurations;

    //Class instance of ProductService
    //ProductService productService = new ProductServiceImpl();
    @Autowired
    @Lazy
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProducts(){
        
        //Showing app configurations
        System.out.println(externalizedConfigurations.toString());

        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

}
