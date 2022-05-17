package com._9r0zov.lucipizza.converters;

import com._9r0zov.lucipizza.model.Order;
import com._9r0zov.lucipizza.model.dto.SimpleOrder;
import com._9r0zov.lucipizza.model.dto.SimplePizza;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class SimpleOrderConverter implements Converter<Order, SimpleOrder> {
    @Override
    public SimpleOrder convert(Order source) {
        return SimpleOrder.builder()
                .address(source.getAddress())
                .deliveryType(source.getDeliveryType())
                .pizzas(source.getPizzas().stream()
                        .map(pizza -> SimplePizza.builder()
                                .size(pizza.getSize())
                                .pizzaOptions(new ArrayList<>(pizza.getPizzaOptions()))
                                .build())
                        .collect(Collectors.toList()))
                .totalPrice(source.getTotalPrice())
                .build();
    }
}
