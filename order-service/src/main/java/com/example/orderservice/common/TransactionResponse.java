package com.example.orderservice.common;

import com.example.orderservice.model.Order;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionResponse {
    private Order order;
    private String transactionId;
    private Double amount;
    private String response;


}
