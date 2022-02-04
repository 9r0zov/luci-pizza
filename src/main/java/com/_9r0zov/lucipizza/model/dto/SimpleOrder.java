package com._9r0zov.lucipizza.model.dto;

import com._9r0zov.lucipizza.model.enums.DeliveryType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.*;

@Data
@SuperBuilder
@JsonInclude(Include.NON_NULL)
public class SimpleOrder {

    private List<SimplePizza> pizzas;
    private DeliveryType deliveryType;
    private Address address;
    private Float totalPrice;

}
