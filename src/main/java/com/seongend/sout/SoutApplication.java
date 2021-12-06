package com.seongend.sout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SoutApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoutApplication.class, args);
    }

}
