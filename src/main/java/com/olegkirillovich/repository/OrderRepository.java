package com.olegkirillovich.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.olegkirillovich.model.Order;
import com.olegkirillovich.model.User;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
    // другие методи заебашу позже
}
