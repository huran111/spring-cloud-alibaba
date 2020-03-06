package com.hr.controller;

import com.hr.entity.CommonResult;
import com.hr.entity.Payment;
import com.hr.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class FeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/comsumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        return this.paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        return paymentFeignService.paymentFeignTimeout();
    }
}
