package com.nithin.ecart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Min(value = 1)
    @Max(value = 5)
    private Double rating;

    public ProductReview(Long id, Double rating, String comment) {
        Id = id;
        this.rating = rating;
        this.comment = comment;
    }

    private String comment;

    @ManyToOne
    @JoinColumn(name = "product_id")

    private Product product;
}
