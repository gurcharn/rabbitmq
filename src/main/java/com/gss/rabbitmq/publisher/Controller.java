package com.gss.rabbitmq.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rabbitmq/")
public class Controller {

  @Autowired
  private AmqpTemplate amqpTemplate;

  @GetMapping(value = "/producer")
  public String producer(@RequestParam("exchangeName") String exchange,
                         @RequestParam("routingKey") String routingKey,
                         @RequestParam("messageData") String messageData) {
    amqpTemplate.convertAndSend(exchange, routingKey, messageData);

    return "Message sent to the RabbitMQ Successfully" +
      "\n" + "Exchange : " + exchange +
      "\n" + "Routing Key : " + routingKey +
      "\n" + "Message : " + messageData;
  }

  @GetMapping(value = "/producer/headers-exchange")
  public String headersProducer(@RequestParam("exchangeName") String exchange,
                         @RequestParam("department") String department,
                         @RequestParam("messageData") String messageData) {
    MessageProperties messageProperties = new MessageProperties();
    messageProperties.setHeader("department", department);
    MessageConverter messageConverter = new SimpleMessageConverter();
    Message message = messageConverter.toMessage(messageData, messageProperties);

    amqpTemplate.convertAndSend(exchange, null, message);

    return "Message sent to the RabbitMQ Successfully" +
      "\n" + "Exchange : " + exchange +
      "\n" + "Department : " + department +
      "\n" + "Message : " + messageData;
  }
}
