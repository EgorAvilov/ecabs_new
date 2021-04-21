package com.itechart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Consumer {
    public static void main(String[] args) {
        SpringApplication.run(Consumer.class, args);
    }
}
