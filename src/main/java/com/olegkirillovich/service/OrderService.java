package com.olegkirillovich.service;

import com.olegkirillovich.model.CartItem;
import com.olegkirillovich.model.Order;
import com.olegkirillovich.model.User;
import com.olegkirillovich.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrdersByUser(User user) {
        return orderRepository.findByUser(user);
    }

    public Order createOrder(User user, List<CartItem> cartItems, double totalAmount) {
        Order order = new Order(user, cartItems, totalAmount);
        order.calculateTotalAmount(); // Вызываем метод для расчета totalAmount
        return orderRepository.save(order);
    }

    public void placeOrder(Order order) {
    }
}
