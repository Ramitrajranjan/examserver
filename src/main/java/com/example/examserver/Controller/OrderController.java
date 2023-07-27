package com.example.examserver.Controller;

import com.example.examserver.model.Order;
import com.example.examserver.model.User;
import com.example.examserver.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable("orderId") Long orderId){
        return this.orderService.getOrderById(orderId);
    }
    @GetMapping("/")
    public ResponseEntity<?> getOrders(){
        return ResponseEntity.ok(this.orderService.getOrders());
    }

    @GetMapping("/user/{id}")
    public List<Order> getQuizzes(@PathVariable("id") Long id){
        User user=new User();
        user.setId(id);
        return (List<Order>) this.orderService.getQuizzesOfUser(user);
    }
    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable("orderId") Long orderId){
     this.orderService.deleteOrder(orderId);
    }


}
