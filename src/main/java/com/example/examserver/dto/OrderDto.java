package com.example.examserver.dto;

import com.example.examserver.model.OrderQuiz;


import java.util.List;

public class OrderDto {
    private List<OrderQuiz> cartItems;
    private Long id;

    public OrderDto(List<OrderQuiz> cartItems, Long id) {
        this.cartItems = cartItems;
        this.id = id;
    }

    public OrderDto() {
    }

    public List<OrderQuiz> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<OrderQuiz> cartItems) {
        this.cartItems = cartItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "cartItems=" + cartItems +
                ", id=" + id +
                '}';
    }
}
