package com._9r0zov.lucipizza.repositories;

import com._9r0zov.lucipizza.model.PizzaSize;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PizzaSizeRepository extends MongoRepository<PizzaSize, String> {
}
