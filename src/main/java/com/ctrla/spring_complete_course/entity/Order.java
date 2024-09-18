package com.ctrla.spring_complete_course.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_address")
    private String customerAddress;
    private String product;
    private String price;
    private Integer quantity;
    private String password;
}
