package com.rabbitmq.assignment.publisher;

import com.rabbitmq.assignment.config.MessageConfig;
import com.rabbitmq.assignment.dto.Customer;
import com.rabbitmq.assignment.dto.CustomerNotification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerPublisher {

    @Autowired
    public RabbitTemplate template;

    @PostMapping("/{directory}")
    public String addCustomer(@RequestBody Customer customer, @PathVariable String directory){
        customer.setCustomerId(UUID.randomUUID().toString());

        CustomerNotification customerNotification = new CustomerNotification(customer,"PROGRESS", "Customer successfully added in :" +directory);
    template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, customerNotification);
    return "Success !!";

    }
}
