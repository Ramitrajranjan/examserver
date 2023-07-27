package com.example.examserver.Controller;

import com.example.examserver.dto.OrderDto;
import com.example.examserver.model.Order;
import com.example.examserver.model.OrderQuiz;
import com.example.examserver.model.User;
import com.example.examserver.services.OrderService;
import com.example.examserver.services.UserService;
import com.example.examserver.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/createOrder")
@CrossOrigin("*")
public class OrderQuizController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    Logger logger= LoggerFactory.getLogger(OrderQuizController.class);
    @PostMapping("/")
    public ResponseEntity<Order> addOrder(@RequestBody OrderDto orderDto){
        logger.info("requested payload  "+orderDto);
        User user=this.userService.getUser(orderDto.getId());
        String date = DateUtil.getCurrentDateTime();
        float basketTotal=this.orderService.getCartAmount(orderDto.getCartItems());
        Order order=new Order(user,date,basketTotal,orderDto.getCartItems());
        Order order1 = this.orderService.createOrder(order);
        return ResponseEntity.ok(order1);
    }
}
