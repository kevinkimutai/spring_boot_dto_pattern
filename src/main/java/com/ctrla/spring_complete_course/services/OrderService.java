package com.ctrla.spring_complete_course.services;

import com.ctrla.spring_complete_course.dto.OrderDto;
import com.ctrla.spring_complete_course.dto.OrderResponseDto;
import com.ctrla.spring_complete_course.entity.Order;
import com.ctrla.spring_complete_course.exception.NotFoundException;
import com.ctrla.spring_complete_course.repo.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    //Get All Orders
    public List<OrderResponseDto> getAllOrders() {
        return orderMapper.toOrderResponseDtoList(orderRepository.findAll());
    }

    //Get Order By ID
    public OrderResponseDto getOrderById(Integer orderId) {
        // Fetch the order or throw a custom exception if not found
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("No such order with that Id"));

        // Map the Order to OrderResponseDto and return
        return orderMapper.toOrderRes(order);
    }

    //Create Order
    public OrderResponseDto createOrder(OrderDto order){
        return orderMapper.toOrderRes(orderRepository.save(orderMapper.toOrder(order)));
    }

    //UpdateOrder
    public OrderResponseDto updateOrder(Integer orderId, OrderDto orderDto){
        // Fetch the existing order from the repository
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("No such order with that Id"));

        // Update only the fields that are provided in the DTO
        if (orderDto.getCustomerName() != null) {
            existingOrder.setCustomerName(orderDto.getCustomerName());
        }
        if (orderDto.getCustomerAddress() != null) {
            existingOrder.setCustomerAddress(orderDto.getCustomerAddress());
        }
        if (orderDto.getProduct() != null) {
            existingOrder.setProduct(orderDto.getProduct());
        }
        if (orderDto.getPrice() != null) {
            existingOrder.setPrice(orderDto.getPrice());
        }
        if (orderDto.getQuantity() != null) {
            existingOrder.setQuantity(orderDto.getQuantity());
        }

        // Save the updated order to the database
        return orderMapper.toOrderRes(orderRepository.save(existingOrder));
    }

    //Delete Order
    public void deleteOrder(Integer orderId){
       orderRepository.deleteById(orderId);
    }
}
