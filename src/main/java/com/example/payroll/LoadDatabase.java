package com.example.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            log.info("Preloading " + employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar")));
            log.info("Preloading " + employeeRepository.save(new Employee("Frodo", "Baggins" , "Ring bearer")));

            employeeRepository.findAll().forEach(employee -> log.info("Preload " + employee));

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("Samsung s21", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> log.info("Preload " + order));
        };
    }
}