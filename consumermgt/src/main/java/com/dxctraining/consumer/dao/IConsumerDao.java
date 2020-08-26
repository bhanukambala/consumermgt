package com.dxctraining.consumer.dao;

import com.dxctraining.consumer.entities.Consumer;

public interface IConsumerDao {
	Consumer add(Consumer consumer);

	Consumer getConsumerById(int id);
}
