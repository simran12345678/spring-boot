package com.example.orderservice.common;

import com.example.orderservice.model.Order;
import lombok.Data;

@Data
public class TransactionRequest {
    private Order order;
    private Payment payment;


}
