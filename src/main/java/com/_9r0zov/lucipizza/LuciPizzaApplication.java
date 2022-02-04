package com._9r0zov.lucipizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class LuciPizzaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuciPizzaApplication.class, args);
    }

}
