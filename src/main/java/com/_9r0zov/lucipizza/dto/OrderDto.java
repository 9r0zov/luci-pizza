package com._9r0zov.lucipizza.dto;

import com._9r0zov.lucipizza.model.enums.DeliveryType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDto {

    String size;
    String city;
    String address;
    DeliveryType delivery;
    List<String> ingredients = new ArrayList<>();

}
