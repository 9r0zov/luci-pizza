package com._9r0zov.lucipizza.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.*;

@Data
@SuperBuilder
@JsonInclude(Include.NON_NULL)
public class SimplePizza {

    private Option size;
    @JsonInclude(Include.NON_EMPTY)
    private List<Option> pizzaOptions;

}
