package com.ctrla.spring_complete_course.services;

import com.ctrla.spring_complete_course.dto.OrderDto;
import com.ctrla.spring_complete_course.dto.OrderResponseDto;
import com.ctrla.spring_complete_course.entity.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {

    private OrderMapper orderMapper;

    @BeforeEach
    void setUp() {
        this.orderMapper = new OrderMapper();
    }

    @Test
    void testToOrder() {
        OrderDto orderDto = new OrderDto();

        orderDto.setCustomerName("Test Name");
        orderDto.setCustomerAddress("Test Address");
        orderDto.setProduct("Test Product");
        orderDto.setPrice("1500");
        orderDto.setQuantity(1);
        orderDto.setPassword("Test Password");

    Order order = orderMapper.toOrder(orderDto);

    //Assert
        assertEquals(order.getCustomerName(), orderDto.getCustomerName());
        assertEquals(order.getCustomerAddress(), orderDto.getCustomerAddress());
        assertEquals(order.getProduct(), orderDto.getProduct());
        assertEquals(order.getPrice(), orderDto.getPrice());
        assertEquals(order.getQuantity(), orderDto.getQuantity());
        assertEquals(order.getPassword(),orderDto.getPassword());
    }

    @Test
    public void testToOrderRes(){
        Order order = new Order();
        order.setOrderId(1);
        order.setCustomerName("Test Name");
        order.setCustomerAddress("Test Address");
        order.setProduct("Test Product");
        order.setPrice("1500");
        order.setQuantity(1);
        order.setPassword("Test Password");

        OrderResponseDto orderResDto = orderMapper.toOrderRes(order);

   assertEquals(order.getOrderId(), orderResDto.getOrderId());
   assertEquals(order.getCustomerName(), orderResDto.getCustomerName());
   assertEquals(order.getCustomerAddress(), orderResDto.getCustomerAddress());
   assertEquals(order.getProduct(), orderResDto.getProduct());
   assertEquals(order.getPrice(), orderResDto.getPrice());
   assertEquals(order.getQuantity(), orderResDto.getQuantity());
    }
}