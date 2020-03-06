package com.hr.controller;


import com.hr.entity.CommonResult;
import com.hr.entity.Payment;
import com.hr.lb.MyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private MyLoadBalancer myLoadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        System.out.println(payment);
        return this.restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return this.restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> forEntity = this.restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }
    @GetMapping(value = "/getPaymentLB")
    public String getPaymentLB() {
        List<ServiceInstance> instances = this.discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = this.myLoadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        System.out.println(serviceInstance.getServiceId());
        return this.restTemplate.getForObject("http://"+serviceInstance.getServiceId() + "/payment/lb", String.class);
    }
}
