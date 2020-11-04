package com.gss.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeaderExchangeConfig {

  @Bean
  HeadersExchange headersExchange() {
    return new HeadersExchange(Constants.HEADER_EXCHANGE);
  }

  @Bean
  Binding marketingBindingHeader(Queue marketingQueue, HeadersExchange headersExchange) {
    return BindingBuilder
      .bind(marketingQueue)
      .to(headersExchange)
      .where("department")
      .matches(Constants.MARKETING_ROUTING_KEY);
  }

  @Bean
  Binding financeBindingHeader(Queue financeQueue, HeadersExchange headersExchange) {
    return BindingBuilder
      .bind(financeQueue)
      .to(headersExchange)
      .where("department")
      .matches(Constants.FINANCE_ROUTING_KEY);
  }

  @Bean
  Binding adminBindingHeader(Queue adminQueue, HeadersExchange headersExchange) {
    return BindingBuilder
      .bind(adminQueue)
      .to(headersExchange)
      .where("department")
      .matches(Constants.ADMIN_ROUTING_KEY);
  }
}
