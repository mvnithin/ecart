package com.nithin.ecart.controller;

import com.nithin.ecart.entity.Product;
import com.nithin.ecart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products=productService.getAllProduct();
        return ResponseEntity.ok(products);
    }
}
