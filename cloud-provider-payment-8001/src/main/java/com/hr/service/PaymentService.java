package com.hr.service;

import com.hr.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int create(Payment payment);

    Payment queryById(@Param("id") Long id);
}
