package com.gss.rabbitmq.config;

public class Constants {

  public static final String MARKETING_QUEUE = "marketingQueue";
  public static final String FINANCE_QUEUE = "financeQueue";
  public static final String ADMIN_QUEUE = "adminQueue";
  public static final String ALL_QUEUE = "allQueue";

  static final String MARKETING_ROUTING_KEY = "queue.marketing";
  static final String FINANCE_ROUTING_KEY = "queue.finance";
  static final String ADMIN_ROUTING_KEY = "queue.admin";
  static final String ALL_ROUTING_KEY = "queue.*";

  static final String DIRECT_EXCHANGE = "direct-exchange";
  static final String FANOUT_EXCHANGE = "fanout-exchange";
  static final String TOPIC_EXCHANGE = "topic-exchange";
  static final String HEADER_EXCHANGE = "headers-exchange";
}
