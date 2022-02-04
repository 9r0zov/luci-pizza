package com._9r0zov.lucipizza.repositories;

import com._9r0zov.lucipizza.model.PizzaOption;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PizzaOptionRepository extends MongoRepository<PizzaOption, String> {
}
