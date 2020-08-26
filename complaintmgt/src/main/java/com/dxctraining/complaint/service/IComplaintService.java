package com.dxctraining.complaint.service;

import java.util.List;

import com.dxctraining.complaint.entities.Complaint;

public interface IComplaintService {
	Complaint add(Complaint complaint);
	Complaint getComplaintById(int id);
	List<Complaint> allComplaintsByConsumer(int consumerid);
}
