package com.example.paymentservice.service;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        System.out.println(payment.getOrderId());
        return paymentRepository.save(payment);
    }


    public String paymentProcessing(){
        return new Random().nextBoolean()?"success":"false";
}

    public Payment findPaymentHistory(int orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

   }

