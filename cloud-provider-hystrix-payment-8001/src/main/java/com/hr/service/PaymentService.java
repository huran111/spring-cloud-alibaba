package com.hr.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentinfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "paymentinfo_OK:" + id;
    }

    //服务降级
    @HystrixCommand(fallbackMethod = "paymentinfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentinfo_TimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "paymentinfo_TimeOut:" + id;
    }

    public String paymentinfo_TimeOutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "paymentinfo_TimeOutHandler :" + id;
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback"
            , commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id 不能为负数");
        }

        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "调用成功，流水号:" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id 不能为负数，请稍后再试！！！"+id;

    }
}
