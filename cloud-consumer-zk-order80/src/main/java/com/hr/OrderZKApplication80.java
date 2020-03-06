package com.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrderZKApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKApplication80.class);
    }
}
