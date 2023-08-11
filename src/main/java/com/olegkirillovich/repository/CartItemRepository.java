package com.olegkirillovich.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.olegkirillovich.model.CartItem;
import com.olegkirillovich.model.Product;
import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCart_User_Id(Long userId);
// Другие методы ебану позже
}

