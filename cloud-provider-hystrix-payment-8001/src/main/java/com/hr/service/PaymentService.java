package com.hr.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentinfo_OK(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"paymentinfo_OK:"+id;
    }
    public String paymentinfo_TimeOut(Integer id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName()+"paymentinfo_TimeOut:"+id;
    }
}
