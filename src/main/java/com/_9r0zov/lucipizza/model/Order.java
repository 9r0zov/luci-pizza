package com._9r0zov.lucipizza.model;

import com._9r0zov.lucipizza.model.dto.Address;
import com._9r0zov.lucipizza.model.dto.Pizza;
import com._9r0zov.lucipizza.model.enums.DeliveryType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class Order {

    @Id
    private String id;
    private LocalDateTime created;
    private LocalDateTime updated = LocalDateTime.now();
    private List<Pizza> pizzas;
    private DeliveryType deliveryType;
    private Address address;
    private float totalPrice;

}
