package com.nithin.ecart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {

    private String name;
    private Integer quantity;
    private String image;
    private Double price;
    private Long productId;
}
