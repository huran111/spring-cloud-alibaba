package com.hr.controller;


import com.hr.entity.CommonResult;
import com.hr.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT";
    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value = "consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        System.out.println(payment);
        return this.restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return this.restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
