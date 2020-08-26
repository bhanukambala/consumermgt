package com.dxctraining.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.dxctraining.consumer.entities.Consumer;
import com.dxctraining.consumer.service.IConsumerService;
import com.dxctraining.dto.ConsumerReq;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {

	@Autowired
	private IConsumerService service;

	@PostMapping("/addconsumers")
	@ResponseStatus(HttpStatus.CREATED)
	public Consumer create(@RequestBody ConsumerReq requestData) {
		String name = requestData.getName();
		Consumer consumer = new Consumer(name);
		consumer = service.add(consumer);
		return consumer;
	}

	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ConsumerReq getConsumerById(@PathVariable("id") int id) {
		Consumer consumer = service.getConsumerById(id);
		ConsumerReq response = util(consumer);
		return response;
	}

	private ConsumerReq util(Consumer consumer) {
		ConsumerReq req = new ConsumerReq();
		req.setId(consumer.getId());
		req.setName(consumer.getName());
		return req;
	}
}
