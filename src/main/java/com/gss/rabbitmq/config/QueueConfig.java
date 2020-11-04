package com.gss.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

  @Bean
  Queue marketingQueue() {
    return new Queue(Constants.MARKETING_QUEUE, false);
  }

  @Bean
  Queue financeQueue() {
    return new Queue(Constants.FINANCE_QUEUE, false);
  }

  @Bean
  Queue adminQueue() {
    return new Queue(Constants.ADMIN_QUEUE, false);
  }

  @Bean
  Queue allQueue() {
    return new Queue(Constants.ALL_QUEUE, false);
  }
}
