package com._9r0zov.lucipizza.repositories;

import com._9r0zov.lucipizza.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
