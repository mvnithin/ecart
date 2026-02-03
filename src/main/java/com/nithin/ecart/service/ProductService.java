package com.nithin.ecart.service;

import com.nithin.ecart.dto.ProductReviewDto;
import com.nithin.ecart.entity.Product;
import com.nithin.ecart.entity.ProductReview;
import com.nithin.ecart.repository.ProductRepository;
import com.nithin.ecart.repository.ProductReviewRepository;
import com.nithin.ecart.spec.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductReviewRepository productReviewRepository;

    public Map<String,Object> getAllProduct(int page, int size){
        Pageable pageable= PageRequest.of(page,size);
        Page<Product> products= productRepository.findAll(pageable);
        Map<String,Object>response=new HashMap();
        response.put("products",products.getContent());
        response.put("totalProducts",products.getTotalElements());

        return response;
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product Not Found with Id: "+id));
    }

    public List<Product> searchProducts(String category,Double minPrice,Double maxPrice,String keyword,Double ratings){
        Specification<Product>spec=Specification.where(ProductSpecification.hasCategory(category))
                .and(ProductSpecification.priceBetween(minPrice,maxPrice))
                .and(ProductSpecification.hasNameOrDescriptionLike(keyword))
                .and(ProductSpecification.ratingsGreaterThan(ratings));

        return productRepository.findAll(spec);
    }

    public void addReview(ProductReviewDto reviewDto){
    Product product = productRepository.findById(reviewDto.getProductId()).orElseThrow(()->new RuntimeException("Product Not Found"));
    ProductReview review=new ProductReview();
    review.setComment(reviewDto.getComment());
    review.setRating(reviewDto.getRating());
    review.setProduct(product);
    productReviewRepository.save(review);
    }

}
