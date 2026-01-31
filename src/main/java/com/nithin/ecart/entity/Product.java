package com.nithin.ecart.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
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

    private Double ratings=0.0;

    @NotBlank(message = "Seller Field is Required")
    private String seller;

    @NotNull(message = "Stock Field is Required")
    private Integer stock;

    private Integer numOfReviews=0;

}
