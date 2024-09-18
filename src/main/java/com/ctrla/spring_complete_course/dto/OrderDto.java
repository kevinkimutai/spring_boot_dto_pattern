package com.ctrla.spring_complete_course.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    @JsonProperty("customer_name")
    @NotEmpty(message = "missing customer_name field")
    private String customerName;
    @JsonProperty("customer_address")
    @NotEmpty(message = "missing customer_address field")
    private String customerAddress;
    @NotEmpty
    private String product;
    @NotEmpty
    private String price;
    @NotNull
    private Integer quantity;
    @NotEmpty
    private String password;
}
