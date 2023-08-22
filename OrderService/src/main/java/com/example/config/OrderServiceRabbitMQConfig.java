package com.example.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceRabbitMQConfig {
	
	public static final String queueName = "customer_order_service_queue";
	@Bean
	MessageConverter converter() {
			
		return new Jackson2JsonMessageConverter();
	}
}
