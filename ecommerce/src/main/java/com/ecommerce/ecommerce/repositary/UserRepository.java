package com.ecommerce.ecommerce.repositary;

import com.ecommerce.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
