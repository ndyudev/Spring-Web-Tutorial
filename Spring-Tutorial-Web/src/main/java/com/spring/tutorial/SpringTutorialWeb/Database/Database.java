package com.spring.tutorial.SpringTutorialWeb.Database;

import com.spring.tutorial.SpringTutorialWeb.Models.Product;
import com.spring.tutorial.SpringTutorialWeb.Repositories.ProductRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
// Now connect with mysql using JPA
/*
docker run -d --rm --name mysql-spring
 */
@Configuration
public class Database {
    // logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product productA = new Product("Macbook Pro 16", 2020, 2400, "");
                Product productB = new Product("IPad Air Green", 2021, 599, "");
                logger.info("insert data: {}", productRepository.save(productA));
                logger.info("insert data: {}", productRepository.save(productB));
            }
        };
    }
}
