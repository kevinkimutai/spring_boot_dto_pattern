package com.ctrla.spring_complete_course.controller;

import com.ctrla.spring_complete_course.dto.OrderDto;
import com.ctrla.spring_complete_course.dto.OrderResponseDto;
import com.ctrla.spring_complete_course.entity.Order;
import com.ctrla.spring_complete_course.services.OrderMapper;
import com.ctrla.spring_complete_course.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

//All a controller should do is req/res

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;
    private final View error;


    public OrderController(OrderService orderService, OrderMapper orderMapper, View error) {
        this.orderService = orderService;
        this.error = error;
    }

    //GetAllOrders
    @GetMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<OrderResponseDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    //Get Order By ID
    @GetMapping("/{orderId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public OrderResponseDto getOrderById(@PathVariable Integer orderId){
        return orderService.getOrderById(orderId);
    }

    //Create Order
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponseDto createOrder(@Valid @RequestBody OrderDto order){
        return orderService.createOrder(order);
    }

    //Update Order
    @PatchMapping("/{orderId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public OrderResponseDto updateOrder(@PathVariable Integer orderId, @RequestBody OrderDto orderDto) {
        return orderService.updateOrder(orderId,orderDto);

    }

    //Delete Order
    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Integer orderId){
        orderService.deleteOrder(orderId);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
        var errors = new HashMap<String,String>();

                ex.getBindingResult().getAllErrors()
                .forEach(error->{
                    var fieldName = ((FieldError)error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName,errorMessage);
                });

                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
