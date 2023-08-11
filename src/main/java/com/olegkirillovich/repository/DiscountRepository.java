package com.olegkirillovich.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.olegkirillovich.model.Discount;

import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    List<Discount> findByPercentageGreaterThan(double percentage);
    // Другие методі заебашу потом
}