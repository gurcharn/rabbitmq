package com.gss.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicExchangeConfig {

  @Bean
  TopicExchange topicExchange() {
    return new TopicExchange(Constants.TOPIC_EXCHANGE);
  }

  @Bean
  Binding marketingBindingTopic(Queue marketingQueue, TopicExchange topicExchange) {
    return BindingBuilder.bind(marketingQueue).to(topicExchange).with(Constants.MARKETING_ROUTING_KEY);
  }

  @Bean
  Binding financeBindingTopic(Queue financeQueue, TopicExchange topicExchange) {
    return BindingBuilder.bind(financeQueue).to(topicExchange).with(Constants.FINANCE_ROUTING_KEY);
  }

  @Bean
  Binding adminBindingTopic(Queue adminQueue, TopicExchange topicExchange) {
    return BindingBuilder.bind(adminQueue).to(topicExchange).with(Constants.ADMIN_ROUTING_KEY);
  }

  @Bean
  Binding allBindingTopic(Queue allQueue, TopicExchange topicExchange) {
    return BindingBuilder.bind(allQueue).to(topicExchange).with(Constants.ALL_ROUTING_KEY);
  }
}
