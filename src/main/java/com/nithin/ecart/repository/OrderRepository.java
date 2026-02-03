package com.nithin.ecart.repository;

import com.nithin.ecart.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {
      Optional<Order> findByReferenceId(String referenceId);
}
