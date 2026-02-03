package com.nithin.ecart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReviewDto {
    private Long productId;
    private String comment;
    private Double rating;
}
