package com.gss.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectExchangeConfig {

  @Bean
  DirectExchange directExchange() {
    return new DirectExchange(Constants.DIRECT_EXCHANGE);
  }

  @Bean
  Binding marketingBindingDirect(Queue marketingQueue, DirectExchange exchange) {
    return BindingBuilder.bind(marketingQueue).to(exchange).with(Constants.MARKETING_ROUTING_KEY);
  }

  @Bean
  Binding financeBindingDirect(Queue financeQueue, DirectExchange exchange) {
    return BindingBuilder.bind(financeQueue).to(exchange).with(Constants.FINANCE_ROUTING_KEY);
  }

  @Bean
  Binding adminBindingDirect(Queue adminQueue, DirectExchange exchange) {
    return BindingBuilder.bind(adminQueue).to(exchange).with(Constants.ADMIN_ROUTING_KEY);
  }
}
