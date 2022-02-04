package com._9r0zov.lucipizza.model;

import com._9r0zov.lucipizza.model.dto.PriceOption;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

@Data
@SuperBuilder
@NoArgsConstructor
public class PizzaOption extends PriceOption {
    @Id
    private String id;

}
