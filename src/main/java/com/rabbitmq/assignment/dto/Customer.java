package com.rabbitmq.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    private String customerId;
    private String name;
    private double phNumber;
    private String address;

}
