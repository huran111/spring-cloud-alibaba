package com.hr.service;

import org.springframework.stereotype.Component;

@Component
public class PayFallbackHystrixService implements PaymentHystrixService {
    @Override
    public String payment_OK(Integer id) {
        return "fallback  payment_OK";
    }

    @Override
    public String payment_TIME(Integer id) {
        return "fallback  payment_TIME";
    }
}
