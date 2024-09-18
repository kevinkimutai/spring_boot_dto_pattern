package com.ctrla.spring_complete_course.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDto {
    private Integer orderId;
    private String customerName;
    private String customerAddress;
    private String product;
    private String price;
    private Integer quantity;
}
