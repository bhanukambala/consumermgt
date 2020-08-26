package com.dxctraining.complaint.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxctraining.complaint.entities.Complaint;
import com.dxctraining.complaint.exceptions.ComplaintNotFoundException;

@Repository
public class ComplaintDaoImpl implements IComplaintDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Complaint add(Complaint complaint) {
		entityManager.persist(complaint);
		return complaint;
	}

	@Override
	public Complaint getComplaintById(int id) {
		Complaint complaint=entityManager.find(Complaint.class,id);
		if(complaint==null) {
			throw new ComplaintNotFoundException("complaint not found for the given id"+id);
		}
		return complaint;
	}


	@Override
	public List<Complaint> allComplaintsByConsumer(int consumerid) {
		String jpaql = "from Complaint where consumerId=:consumer";
		TypedQuery<Complaint> query = entityManager.createQuery(jpaql, Complaint.class);
		query.setParameter("consumer", consumerid);
		List<Complaint> complaintList = query.getResultList();
		return complaintList;
	}
	
}
