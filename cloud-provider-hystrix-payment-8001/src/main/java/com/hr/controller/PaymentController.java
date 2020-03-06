package com.hr.controller;

import com.hr.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/paymentok/{id}")
    public String payment_OK(@PathVariable("id") Integer id) {
        return this.paymentService.paymentinfo_OK(id);
    }

    @GetMapping(value = "/paymenttimeout/{id}")
    public String payment_TIME(@PathVariable("id") Integer id) {
        return this.paymentService.paymentinfo_TimeOut(id);
    }
}
