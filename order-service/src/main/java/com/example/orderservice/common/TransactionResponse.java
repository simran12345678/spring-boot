package com.example.orderservice.common;

import com.example.orderservice.model.Order;
import lombok.Data;

@Data
public class TransactionResponse {
    private Order order;
    private String transactionId;
    private Double amount;
    private String response;


}
