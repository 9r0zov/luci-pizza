package com._9r0zov.lucipizza.config;

import com._9r0zov.lucipizza.model.PizzaOption;
import com._9r0zov.lucipizza.model.PizzaSize;
import com._9r0zov.lucipizza.repositories.PizzaOptionRepository;
import com._9r0zov.lucipizza.repositories.PizzaSizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DefaultDBOptionsSaverEventListener {

    private final PizzaOptionRepository pizzaOptionRepository;
    private final PizzaSizeRepository pizzaSizeRepository;

    @EventListener
    public void onContextRefresh(ContextRefreshedEvent event) {
        if (pizzaOptionRepository.count() < 1) {
            pizzaOptionRepository.save(PizzaOption.builder()
                    .name("bacon")
                    .price(0.99f)
                    .build());
            pizzaOptionRepository.save(PizzaOption.builder()
                    .name("pepperoni")
                    .price(0.99f)
                    .build());
            pizzaOptionRepository.save(PizzaOption.builder()
                    .name("salami")
                    .price(0.99f)
                    .build());
            pizzaOptionRepository.save(PizzaOption.builder()
                    .name("cheese")
                    .price(0.99f)
                    .build());
            pizzaOptionRepository.save(PizzaOption.builder()
                    .name("black-olives")
                    .price(0.99f)
                    .build());
            pizzaOptionRepository.save(PizzaOption.builder()
                    .name("sausage")
                    .price(0.99f)
                    .build());
        }

        if (pizzaSizeRepository.count() < 1) {
            pizzaSizeRepository.save(PizzaSize.builder()
                    .name("12")
                    .price(13.99f)
                    .build());
            pizzaSizeRepository.save(PizzaSize.builder()
                    .name("16")
                    .price(16.99f)
                    .build());
            pizzaSizeRepository.save(PizzaSize.builder()
                    .name("18")
                    .price(18.99f)
                    .build());
            pizzaSizeRepository.save(PizzaSize.builder()
                    .name("72")
                    .price(148.99f)
                    .build());
        }
    }

}
