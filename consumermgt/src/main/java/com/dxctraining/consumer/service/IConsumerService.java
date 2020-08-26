package com.dxctraining.consumer.service;

import com.dxctraining.consumer.entities.Consumer;

public interface IConsumerService {
	Consumer add(Consumer consumer);

	Consumer getConsumerById(int id);
}
