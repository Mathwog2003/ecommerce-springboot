package com.ecommerce.ecommerce.repositary;

import com.ecommerce.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
