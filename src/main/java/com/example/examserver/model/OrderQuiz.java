package com.example.examserver.model;

import com.example.examserver.model.exam.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class OrderQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long qId;
    private Long price;

    public OrderQuiz(String title, Long qId, Long price) {
        this.title = title;
        this.qId = qId;
        this.price = price;
    }

    public OrderQuiz() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getqId() {
        return qId;
    }

    public void setqId(Long qId) {
        this.qId = qId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderQuiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", qId=" + qId +
                ", price=" + price +
                '}';
    }
}
