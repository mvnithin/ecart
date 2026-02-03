package com.nithin.ecart.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReviewDto {
    @NotNull(message = "Product ID is required")
    private Long productId;
    @NotBlank(message = "Comments can't be Blank")
    private String comment;
    @NotNull(message = "Rating is Required")
    private Double rating;
}
