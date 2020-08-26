package com.dxctraining.consumer.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.consumer.dao.IConsumerDao;
import com.dxctraining.consumer.entities.Consumer;
import com.dxctraining.consumer.exceptions.InvalidArgumentException;

@Transactional
@Service
public class ConsumerServiceImpl implements IConsumerService{
	@Autowired
	private IConsumerDao dao;

	@Override
	public Consumer add(Consumer consumer) {
		validate(consumer);
		dao.add(consumer);
		return consumer;
	}

	private void validate(Object obj) {
		if(obj==null) {
			throw new InvalidArgumentException("argument is null");
		}
		
	}

	@Override
	public Consumer getConsumerById(int id) {
		Consumer consumer=dao.getConsumerById(id);
		return consumer;
	}
	
}
