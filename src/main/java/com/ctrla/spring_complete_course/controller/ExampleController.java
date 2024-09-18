package com.ctrla.spring_complete_course.controller;

import com.ctrla.spring_complete_course.dto.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/example")
public class ExampleController {
    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello(){
        return "Hello World!";
    }

    @PostMapping("/message")
    @ResponseStatus(HttpStatus.CREATED)
    public String createMsg(@RequestBody String msg ){

        return "Message received.Message is: " + msg;
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String printName(@PathVariable String name){
        return "Hi "+name;
    }

    @GetMapping("/params")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String printOrderParams(@RequestParam String first_name){
        return "Params are "+first_name;
    }
}
