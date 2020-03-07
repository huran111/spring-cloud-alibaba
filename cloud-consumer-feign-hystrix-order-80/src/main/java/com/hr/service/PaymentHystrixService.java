package com.hr.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT-8001",fallback = PayFallbackHystrixService.class)
public interface PaymentHystrixService {
    @GetMapping(value = "/paymentok/{id}")
    String payment_OK(@PathVariable("id") Integer id);

    @GetMapping(value = "/paymenttimeout/{id}")
    String payment_TIME(@PathVariable("id") Integer id);
}
