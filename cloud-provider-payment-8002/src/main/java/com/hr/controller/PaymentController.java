package com.hr.controller;

import com.hr.entity.CommonResult;
import com.hr.entity.Payment;
import com.hr.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment) {
        int i = this.paymentService.create(payment);
        System.out.println(serverPort);
        if (i > 0) {
            return new CommonResult<>(200, "插入成功");
        } else {
            return new CommonResult<>(444, "插入失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        System.out.println(serverPort);
        Payment paymentById = this.paymentService.queryById(id);
        System.out.println(id);
        if (paymentById != null) {
            return new CommonResult<>(200, "查询成功", paymentById);

        } else {
            return new CommonResult<>(200, "查询失败", paymentById);
        }
    }

}
