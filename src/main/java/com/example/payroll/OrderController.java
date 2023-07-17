package com.example.payroll;

import org.springframework.web.bind.annotation.RestController;

@RestController
class OrderController {

    private final OrderRepository orderRepository;
    private final OrderModelAssembler assembler;
}