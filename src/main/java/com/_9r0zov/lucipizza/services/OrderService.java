package com._9r0zov.lucipizza.services;

import com._9r0zov.lucipizza.model.Order;
import com._9r0zov.lucipizza.model.dto.PriceOption;
import com._9r0zov.lucipizza.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class OrderService {

    private final OrderRepository orderRepository;

    public void save(Order order) {
        order.setCreated(LocalDateTime.now());
        order.setTotalPrice(countTotalPrice(order));

        Order saved = orderRepository.save(order);
        log.info("Saved order id: {}", saved.getId());
    }

    private float countTotalPrice(Order order) {
        Double price = order.getPizzas().stream()
                .mapToDouble(pizza -> pizza.getPizzaOptions().stream()
                        .mapToDouble(PriceOption::getPrice).sum()
                        + pizza.getSize().getPrice())
                .sum();
        return price.floatValue();
    }

    public List<Order> getAllOrders() {
        log.info("Retrieving all orders from DB");
        return orderRepository.findAll();
    }
}
