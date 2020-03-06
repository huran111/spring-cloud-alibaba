package com.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderZkController {

    public static final String url = "http://cloud-provider-payment";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/paymengInfo")
    public Object paymengInfo() {
        String forObject = restTemplate.getForObject(url + "/payment/zk", String.class);
        return forObject;
    }
}
