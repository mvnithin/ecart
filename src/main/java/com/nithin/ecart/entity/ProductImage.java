package com.nithin.ecart.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String publicId;
    private String url;
    public ProductImage(String url,Product product){
        this.url="/uploads"+url;
        this.publicId=url;
        this.product=product;
    }

}
