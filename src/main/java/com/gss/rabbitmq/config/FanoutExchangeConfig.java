package com.gss.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutExchangeConfig {

  @Bean
  FanoutExchange fanoutExchange() {
    return new FanoutExchange(Constants.FANOUT_EXCHANGE);
  }

  @Bean
  Binding marketingBindingFanout(Queue marketingQueue, FanoutExchange fanoutExchange) {
    return BindingBuilder.bind(marketingQueue).to(fanoutExchange);
  }

  @Bean
  Binding financeBindingFanout(Queue financeQueue, FanoutExchange fanoutExchange) {
    return BindingBuilder.bind(financeQueue).to(fanoutExchange);
  }

  @Bean
  Binding adminBindingFanout(Queue adminQueue, FanoutExchange fanoutExchange) {
    return BindingBuilder.bind(adminQueue).to(fanoutExchange);
  }
}
