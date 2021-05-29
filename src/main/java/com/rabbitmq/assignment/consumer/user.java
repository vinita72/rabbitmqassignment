package com.rabbitmq.assignment.consumer;

import com.rabbitmq.assignment.config.MessageConfig;
import com.rabbitmq.assignment.dto.CustomerNotification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class user {

@RabbitListener(queues = MessageConfig.QUEUE)
    public void consumeMessageFromueue(CustomerNotification customerNotification){
    System.out.println("Message received from Queue " +customerNotification);
}
}
