package com.example.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.RabbitMQConfiguration;
import com.example.model.CustomerRequest;

@RestController
public class CustomerServiceController {

	@Autowired
	RabbitTemplate template;
	
	@RequestMapping(value = "/customerService", method = RequestMethod.POST,
			produces = "application/json", consumes="application/json")
	public void customerOrderRequest(@RequestBody CustomerRequest customerRequest) {
			
		template.convertAndSend(RabbitMQConfiguration.topicExchangeName, RabbitMQConfiguration.ROUTING_KEY , customerRequest);
	}
}
