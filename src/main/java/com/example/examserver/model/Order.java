package com.example.examserver.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "`Order`")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    private String orderDate;
    private float price;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = OrderQuiz.class)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<OrderQuiz> cartItems;

    public Order(User user, String orderDate, float price, List<OrderQuiz> cartItems) {
        this.user = user;
        this.orderDate = orderDate;
        this.price = price;
        this.cartItems = cartItems;
    }
}
