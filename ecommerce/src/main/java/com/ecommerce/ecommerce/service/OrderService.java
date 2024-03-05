package com.ecommerce.ecommerce.service;

// OrderService.java
import com.ecommerce.ecommerce.entity.Order;
import com.ecommerce.ecommerce.repositary.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.orElse(null);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long orderId, Order updatedOrder) {
        if (orderRepository.existsById(orderId)) {
            updatedOrder.setId(orderId);
            return orderRepository.save(updatedOrder);
        }
        return null; // Order with given ID not found
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}

