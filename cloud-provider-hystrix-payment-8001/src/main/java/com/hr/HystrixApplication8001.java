package com.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class HystrixApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication8001.class);
    }
}
