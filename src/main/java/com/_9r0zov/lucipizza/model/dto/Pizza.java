package com._9r0zov.lucipizza.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class Pizza {
    private PriceOption size;
    private List<PriceOption> pizzaOptions;
}
