package org.boynesoftware.requestgateway.controller;

import org.boynesoftware.requestprocessor.model.SupportRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupportRequestController {
	final static String queueName = "spring-boot";

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	private MessageConverter messageConverter;

	@RequestMapping(value = "/supportRequest", method = RequestMethod.PUT)
	@ResponseBody
	public String createSystemRequest(@RequestBody SupportRequest s) {
		System.err.println(s);
		rabbitTemplate.setMessageConverter(messageConverter);
		rabbitTemplate.convertAndSend(queueName,s	);
		return "blah";
	}

	@RequestMapping(value = "/supportRequest/{id}", method = RequestMethod.GET)
	public SupportRequest createSystemRequest(
			@PathVariable(value = "id") Long id) {
		return new SupportRequest("source");
	}
}
