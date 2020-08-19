package com.example.orderservice.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_TB")
@Data
public class Order {
    @Id
    private int id;
    private String name;
    private double price;
    private int qty;


}
