package com.nithin.ecart.controller;

import com.nithin.ecart.dto.CreateOrderRequest;
import com.nithin.ecart.dto.OrderCreated;
import com.nithin.ecart.entity.Order;
import com.nithin.ecart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest orderRequest){
        OrderCreated orderCreated = orderService.createOrder(orderRequest);
        return ResponseEntity.ok().body(orderCreated);
    }

    @GetMapping("/{refId}")
    public ResponseEntity<?> getOrder(@PathVariable String refId){
        Order order = orderService.getOrder(refId);
        return ResponseEntity.ok().body(order);
    }
}

