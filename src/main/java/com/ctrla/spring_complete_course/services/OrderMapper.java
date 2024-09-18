package com.ctrla.spring_complete_course.services;

import com.ctrla.spring_complete_course.dto.OrderDto;
import com.ctrla.spring_complete_course.dto.OrderResponseDto;
import com.ctrla.spring_complete_course.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderMapper {
    //ConvertDTO
    public Order toOrder(OrderDto orderDto){
        Order order = new Order();

        order.setCustomerName(orderDto.getCustomerName());
        order.setCustomerAddress(orderDto.getCustomerAddress());
        order.setProduct(orderDto.getProduct());
        order.setPrice(orderDto.getPrice());
        order.setQuantity(orderDto.getQuantity());
        order.setPassword(orderDto.getPassword());
        return order;
    }

    public OrderResponseDto toOrderRes(Order order){
        OrderResponseDto orderRes = new OrderResponseDto();

        orderRes.setOrderId(order.getOrderId());
        orderRes.setCustomerName(order.getCustomerName());
        orderRes.setCustomerAddress(order.getCustomerAddress());
        orderRes.setProduct(order.getProduct());
        orderRes.setPrice(order.getPrice());
        orderRes.setQuantity(order.getQuantity());

        return orderRes;
    }

    public List<OrderResponseDto> toOrderResponseDtoList(List<Order> orders) {
        return orders.stream()
                .map(this::toOrderRes)
                .collect(Collectors.toList());
    }



}
