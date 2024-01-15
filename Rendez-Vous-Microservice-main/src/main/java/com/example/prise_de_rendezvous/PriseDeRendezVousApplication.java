package com.example.prise_de_rendezvous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PriseDeRendezVousApplication {

    public static void main(String[] args) {
        SpringApplication.run(PriseDeRendezVousApplication.class, args);
    }

}
