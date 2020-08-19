package com.example.orderservice.service;

import com.example.orderservice.common.Payment;
import com.example.orderservice.common.TransactionRequest;
import com.example.orderservice.common.TransactionResponse;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.hibernate.dialect.SybaseAnywhereDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    @Lazy
    private RestTemplate template;

    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;

    public TransactionResponse saveOrder(TransactionRequest transactionRequest)
    {
        String response="";
        Order order=transactionRequest.getOrder();
        System.out.println(order.getPrice());
        Payment payment=transactionRequest.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

       Payment paymentResponse= template.postForObject(ENDPOINT_URL,payment,Payment.class);

       response=paymentResponse.getPaymentStatus().equals("success")?"payment successful":"payment unsuccessful .Try later";
       orderRepository.save(order);
       System.out.println(paymentResponse.getOrderId());
       return new TransactionResponse(order,paymentResponse.getTransactionId(),paymentResponse.getAmount(),response);
    }


}
