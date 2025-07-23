package com.example.order_ms.controller;

import com.example.order_ms.UserServiceClient;
import com.netflix.discovery.converters.Auto;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {


    private final UserServiceClient userServiceClient;

    @Autowired
    public OrderController(UserServiceClient userServiceClient){
        this.userServiceClient = userServiceClient;
    }

    @GetMapping("/info")
    public String getOrderInfo() {
        return "Order Information";
    }

    @GetMapping("/{id}")
    public String getOrder(@PathVariable Long id){

        // Call userService for user details.
        String user = userServiceClient.getUser(1L);
        return "Order with ID :"+ id + "for user :"+ user;
    }
}