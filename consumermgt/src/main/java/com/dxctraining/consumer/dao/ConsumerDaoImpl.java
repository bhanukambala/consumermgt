package com.dxctraining.consumer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dxctraining.consumer.entities.Consumer;
import com.dxctraining.consumer.exceptions.ConsumerNotFoundException;

@Repository
public class ConsumerDaoImpl implements IConsumerDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Consumer add(Consumer consumer) {
		entityManager.persist(consumer);
		return consumer;
	}

	@Override
	public Consumer getConsumerById(int id) {
		Consumer consumer=entityManager.find(Consumer.class,id);
		if(consumer==null) {
			throw new ConsumerNotFoundException("consumer not found for the given id"+id);
		}
		return consumer;
	}

	
	
}
