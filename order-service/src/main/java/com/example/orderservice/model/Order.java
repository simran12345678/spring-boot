package com.example.orderservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
