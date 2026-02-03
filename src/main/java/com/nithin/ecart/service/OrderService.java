package com.nithin.ecart.service;

import com.nithin.ecart.dto.CreateOrderRequest;
import com.nithin.ecart.dto.OrderCreated;
import com.nithin.ecart.dto.OrderItemDto;
import com.nithin.ecart.entity.Order;
import com.nithin.ecart.entity.OrderItem;
import com.nithin.ecart.entity.Product;
import com.nithin.ecart.repository.OrderRepository;
import com.nithin.ecart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private ProductRepository prodRepo;
    @Autowired
    private OrderRepository orderRepo;

    public OrderCreated createOrder(CreateOrderRequest orderRequest){
        Order order=new Order();
        order.setStatus("PENDING");
        double totalItemsAmount = 0;

        for(OrderItemDto item:orderRequest.getOrderItems()){
            OrderItem orderItem=new OrderItem();
            orderItem.setName(item.getName());
            orderItem.setPrice(item.getPrice());
            orderItem.setImage(item.getImage());
            orderItem.setQuantity(item.getQuantity());

            Product product = prodRepo.findById(item.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
            orderItem.setProduct(product);
            totalItemsAmount += item.getPrice() * item.getQuantity();

            order.getOrderItems().add(orderItem);
        }
        order.setTotalItemsAmount(totalItemsAmount);
        double totalAmount = 0;
        double taxAmount = 10;
        totalAmount = totalItemsAmount  + taxAmount;
        order.setTotalAmount(totalAmount);
        order.setTaxAmount(taxAmount);
        String refId=UUID.randomUUID().toString();
        order.setReferenceId(refId);
       orderRepo.save(order);
       return new OrderCreated(refId);
    }
    public Order getOrder(String refId){
        return orderRepo.findByReferenceId(refId).orElseThrow(()->new RuntimeException("Order Not Found"));
    }
}
