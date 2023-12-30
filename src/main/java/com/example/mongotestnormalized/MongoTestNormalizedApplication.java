package com.example.mongotestnormalized;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.mongotestnormalized.repository")
public class MongoTestNormalizedApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoTestNormalizedApplication.class, args);
    }

}
