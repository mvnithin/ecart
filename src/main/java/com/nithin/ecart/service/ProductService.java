package com.nithin.ecart.service;

import com.nithin.ecart.entity.Product;
import com.nithin.ecart.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public List<Product> getAllProduct(){
       List<Product> products= productRepository.findAll();
       return products;
    }
}
