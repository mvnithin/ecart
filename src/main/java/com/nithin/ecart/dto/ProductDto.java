package com.nithin.ecart.dto;

import com.nithin.ecart.entity.ProductImage;
import com.nithin.ecart.entity.ProductReview;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String category;
    private Double ratings=0.0;
    private String seller;
    private Integer stock;
    private Integer numOfReviews=0;
    private List<ProductImage> images;
    private List<ProductReviewDto> reviews;

    public void Product(Long id, String name, Double price, String description,String category ,Double ratings, String seller, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category=category;
        this.ratings = ratings;
        this.seller = seller;
        this.stock = stock;
    }
}
