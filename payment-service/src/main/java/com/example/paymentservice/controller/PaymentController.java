package com.example.paymentservice.controller;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody  Payment payment){

        return paymentService.doPayment(payment);
    }

    @GetMapping("/history/{orderId}")
    public Payment findPaymentHistory(@PathVariable int orderId){
        return paymentService.findPaymentHistory(orderId);
    }


}


