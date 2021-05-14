package com.raphaelfeitosa.springbootionic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootionicApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootionicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
