package com.nithin.ecart.service;

import com.nithin.ecart.entity.Product;
import com.nithin.ecart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Map<String,Object> getAllProduct(int page, int size){
        Pageable pageable= PageRequest.of(page,size);
        Page<Product> products= productRepository.findAll(pageable);
        Map<String,Object>response=new HashMap();
        response.put("products",products.getContent());
        response.put("totalProducts",products.getTotalElements());

        return response;
    }
}
