package com._9r0zov.lucipizza.controllers;

import com._9r0zov.lucipizza.converters.OrderDtoConverter;
import com._9r0zov.lucipizza.dto.OrderDto;
import com._9r0zov.lucipizza.model.Order;
import com._9r0zov.lucipizza.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderDtoConverter orderDtoConverter;

    @PostMapping("/orders")
    public ResponseEntity saveOrder(OrderDto orderDto) {
        orderService.save(orderDtoConverter.convert(orderDto));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok().body(orderService.getAllOrders());
    }

}
