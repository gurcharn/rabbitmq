package com.gss.rabbitmq.consumer;

import com.gss.rabbitmq.config.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

  @RabbitListener(queues = Constants.MARKETING_QUEUE)
  public void marketingQueueConsumer(String message) {
    System.out.println("Consumed message from Marketing Queue : " + message);
  }

  @RabbitListener(queues = Constants.FINANCE_QUEUE)
  public void financeQueueConsumer(String message) {
    System.out.println("Consumed message from Finance Queue : " + message);
  }

  @RabbitListener(queues = Constants.ADMIN_QUEUE)
  public void adminQueueConsumer(String message) {
    System.out.println("Consumed message from Admin Queue : " + message);
  }

  @RabbitListener(queues = Constants.ALL_QUEUE)
  public void allQueueConsumer(String message) {
    System.out.println("Consumed message from All Queue : " + message);
  }
}
