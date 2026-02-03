package com.nithin.ecart.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "products")
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name Field is Required")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Price Field is Required")
    @PositiveOrZero(message = "Value must be zero or greater than 0")
    private Double price;

    @NotBlank(message = "Description Field is Required")
    private String description;

    private String category;

    private Double ratings=0.0;

    @NotBlank(message = "Seller Field is Required")
    private String seller;

    @NotNull(message = "Stock Field is Required")
    private Integer stock;

    private Integer numOfReviews=0;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductImage> images;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductReview> reviews;

    public Product(Long id, String name, Double price, String description,String category ,Double ratings, String seller, Integer stock,List<String> images) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category=category;
        this.ratings = ratings;
        this.seller = seller;
        this.stock = stock;
        this.images=images.stream().map(url -> new ProductImage(url,this)).collect(Collectors.toList());
    }
}
