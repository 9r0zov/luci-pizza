package com._9r0zov.lucipizza.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class PriceOption extends Option {

    private Float price;

}
