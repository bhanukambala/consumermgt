package com.dxctraining.complaint.dao;

import java.util.List;

import com.dxctraining.complaint.entities.Complaint;

public interface IComplaintDao {

	Complaint add(Complaint complaint);
	Complaint getComplaintById(int id);
	List<Complaint> allComplaintsByConsumer(int consumerid);
}
