package com.hr.service.impl;

import com.hr.dao.PaymentDao;
import com.hr.entity.Payment;
import com.hr.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return this.paymentDao.create(payment);
    }

    @Override
    public Payment queryById(Long id) {
        return this.paymentDao.queryById(id);
    }
}
