package com.ecommerce.ecommerce.service;

// OrderItemService.java
import com.ecommerce.ecommerce.entity.OrderItem;
import com.ecommerce.ecommerce.repositary.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Long orderItemId) {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(orderItemId);
        return optionalOrderItem.orElse(null);
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public OrderItem updateOrderItem(Long orderItemId, OrderItem updatedOrderItem) {
        if (orderItemRepository.existsById(orderItemId)) {
            updatedOrderItem.setId(orderItemId);
            return orderItemRepository.save(updatedOrderItem);
        }
        return null; // OrderItem with given ID not found
    }

    public void deleteOrderItem(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }
}
