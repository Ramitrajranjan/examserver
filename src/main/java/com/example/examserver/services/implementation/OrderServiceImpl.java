package com.example.examserver.services.implementation;
import com.example.examserver.model.Order;
import com.example.examserver.model.OrderQuiz;
import com.example.examserver.model.User;
import com.example.examserver.repository.OrderRepository;
import com.example.examserver.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Override
    public Order createOrder(Order order) {
        return this.orderRepository.save(order);
    }
    @Override
    public List<Order> getOrders() {
        return this.orderRepository.findAll();
    }
    @Override
    public Order getOrderById(Long orderId) {
        return this.orderRepository.findById(orderId).get();
    }

    @Override
    public void deleteOrder(Long orderId) {
        this.orderRepository.deleteById(orderId);
    }

    @Override
    public List<Order> getQuizzesOfUser(User user) {
        return this.orderRepository.findByUser(user);
    }
    @Override
    public float getCartAmount(List<OrderQuiz> orderQuizList) {
        float amount=0;
        for(OrderQuiz quiz:orderQuizList)
        {
            amount+=quiz.getPrice();
        }
        return amount;
    }
}

