package com.example.ordercommand.controller;

import com.example.ordercommand.domain.request.OrderRequest;
import com.example.ordercommand.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final OrderService service;
    @PostMapping
    public void save(OrderRequest request){
        service.save(request);
    }
}
