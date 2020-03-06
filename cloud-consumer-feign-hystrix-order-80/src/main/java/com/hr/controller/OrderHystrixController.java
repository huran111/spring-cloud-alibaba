package com.hr.controller;

import com.hr.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping(value = "/comsumer")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;
    @GetMapping(value = "/paymentok/{id}")
    public String payment_OK(@PathVariable("id") Integer id) {
        return this.paymentHystrixService.payment_OK(id);
    }

    @GetMapping(value = "/paymenttimeout/{id}")
    public String payment_TIME(@PathVariable("id") Integer id) {
        return this.paymentHystrixService.payment_TIME(id);
    }
}
