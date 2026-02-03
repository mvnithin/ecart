package com.nithin.ecart.spec;

import com.nithin.ecart.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {
    public static Specification<Product> hasCategory(String category){
        return ((root, query, criteriaBuilder) -> category == null? null: criteriaBuilder.equal(root.get("category"),category));
    }
    public static Specification<Product> priceBetween(Double min,Double max){
        return (root, query, criteriaBuilder) -> {
            if(min==null && max==null) return null;
            if(min==null) return criteriaBuilder.lessThanOrEqualTo(root.get("price"),max);
            if(max==null) return criteriaBuilder.lessThanOrEqualTo(root.get("price"),min);
            return criteriaBuilder.between(root.get("price"),min,max);
        };
    }
}
