package com.nithin.ecart.controller;

import com.nithin.ecart.entity.Product;
import com.nithin.ecart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Map<String,Object> getAllProducts(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "5")int size){
    //    List<Product> products=productService.getAllProduct();
        return productService.getAllProduct(page,size);
    }
}
