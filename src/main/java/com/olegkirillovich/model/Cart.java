package com.olegkirillovich.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems = new ArrayList<>();

    private double totalAmount;

    public Cart() {
    }

    public Cart(User user) {
        this.user = user;
    }

    // Метод для добавления товара в корзину
    public void addCartItem(CartItem cartItem) {
        cartItems.add(cartItem);
        recalculateTotalAmount();
    }

    // Метод для удаления товара из корзины
    public void removeCartItem(CartItem cartItem) {
        cartItems.remove(cartItem);
        recalculateTotalAmount();
    }

    // Метод для пересчета общей суммы на основе товаров в корзине
    private void recalculateTotalAmount() {
        totalAmount = cartItems.stream()
                .mapToDouble(CartItem::getSubtotal)
                .sum();
    }

    // Метод для оформления заказа (перевода товаров из корзины в заказ и т.д.)
    public Order createOrder() {
        Order order = new Order(user, cartItems); // Здесь создаем заказ, передавая пользователю и список элементов корзины
        return order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
        recalculateTotalAmount();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
