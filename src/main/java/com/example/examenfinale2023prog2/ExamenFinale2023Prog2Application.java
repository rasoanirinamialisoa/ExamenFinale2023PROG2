package com.example.examenfinale2023prog2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.examenfinale2023prog2", "com.example.examenfinale2023prog2.controller"})
public class ExamenFinale2023Prog2Application {

    public static void main(String[] args) {
        SpringApplication.run(ExamenFinale2023Prog2Application.class, args);
    }
}
