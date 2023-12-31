package com.example.examserver.repository;

import com.example.examserver.model.Order;
import com.example.examserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> findByUser(User user);
}
