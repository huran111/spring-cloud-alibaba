package com.hr.controller;

import com.hr.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
//全局
@DefaultProperties(defaultFallback = "global_paymentMethod")
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
//    @HystrixCommand(fallbackMethod = "paymentinfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    //@HystrixCommand//全局
    @GetMapping(value = "/paymenttimeout/{id}")
    public String payment_TIME(@PathVariable("id") Integer id) {
        return this.paymentHystrixService.payment_TIME(id);
    }
    public String paymentinfo_TimeOutHandler(Integer id){
        return "线程池:" + Thread.currentThread().getName() + "payment_TIME_consumer_order :" + id;
    }

    public String global_paymentMethod(){
        return "global";
    }


}
