package com.example.examserver.services;

import com.example.examserver.model.Order;
import com.example.examserver.model.OrderQuiz;
import com.example.examserver.model.User;
import com.example.examserver.model.exam.Quiz;

import java.util.List;

public interface OrderService {
    public Order createOrder(Order order);
    public List<Order> getOrders();
    public Order getOrderById(Long orderId);

    public void deleteOrder(Long orderId);
    public List<Order> getQuizzesOfUser(User user);
    float getCartAmount(List<OrderQuiz> orderQuizList);
}

