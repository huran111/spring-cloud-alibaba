package com.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PayMentApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentApplication8002.class, args);
    }
}
