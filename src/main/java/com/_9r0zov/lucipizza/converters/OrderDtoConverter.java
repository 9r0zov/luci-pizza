package com._9r0zov.lucipizza.converters;

import com._9r0zov.lucipizza.dto.OrderDto;
import com._9r0zov.lucipizza.model.Order;
import com._9r0zov.lucipizza.model.PizzaOption;
import com._9r0zov.lucipizza.model.PizzaSize;
import com._9r0zov.lucipizza.model.dto.Address;
import com._9r0zov.lucipizza.model.dto.Pizza;
import com._9r0zov.lucipizza.model.dto.PriceOption;
import com._9r0zov.lucipizza.repositories.PizzaOptionRepository;
import com._9r0zov.lucipizza.repositories.PizzaSizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class OrderDtoConverter implements Converter<OrderDto, Order> {

    private final PizzaSizeRepository pizzaSizeRepository;
    private final PizzaOptionRepository pizzaOptionRepository;

    @Override
    public Order convert(OrderDto orderDto) {
        List<PizzaSize> sizes = pizzaSizeRepository.findAll();
        List<PizzaOption> options = pizzaOptionRepository.findAll();

        Pizza pizza = Pizza.builder()
                .pizzaOptions(new ArrayList<>())
                .pizzaOptions(orderDto.getIngredients().stream()
                        .map(ingredient -> addPizzaOptionByName(options, ingredient))
                        .filter(Objects::nonNull)
                        .collect(toList()))
                .size(getPizzaSizeByName(orderDto.getSize(), sizes))
                .build();

        return Order.builder()
                .address(Address.builder()
                        .city(orderDto.getCity())
                        .street(orderDto.getAddress())
                        .build())
                .deliveryType(orderDto.getDelivery())
                .pizzas(Collections.singletonList(pizza))
                .build();
    }

    private PriceOption getPizzaSizeByName(String orderSize, List<PizzaSize> sizes) {
        return sizes.stream().filter(size -> size.getName().equals(orderSize))
                .findFirst()
                .map(
                        size -> PriceOption.builder()
                                .name(size.getName())
                                .price(size.getPrice())
                                .build())
                .orElse(null);
    }

    private PriceOption addPizzaOptionByName(List<PizzaOption> options, String name) {
        return options.stream().filter(opt -> opt.getName().equals(name))
                .findFirst()
                .map(opt -> PriceOption.builder()
                        .name(opt.getName())
                        .price(opt.getPrice())
                        .build())
                .orElse(null);
    }
}
