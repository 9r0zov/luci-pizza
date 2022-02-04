package com._9r0zov.lucipizza.model.enums;

import lombok.Getter;

@Getter
public enum DeliveryType {

    DELIVERY("delivery"),
    PICKUP("pickup");

    private String name;

    DeliveryType(String name) {
        this.name = name;
    }

}
