package com.dxctraining.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.complaint.entities.Complaint;
import com.dxctraining.complaint.service.IComplaintService;
import com.dxctraining.dto.ComplaintReq;
import com.dxctraining.dto.ConsumerReq;
import com.dxctraining.util.ComplaintUtil;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

	@Autowired
	private IComplaintService complaintservice;
	
	@Autowired
	private ComplaintUtil complaintutil;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ComplaintReq add(@RequestBody ComplaintReq requestData) {
		String description=requestData.getDescription();
		int consumerid=requestData.getId();
		Complaint complaint=new Complaint(description,consumerid);
		complaint=complaintservice.add(complaint);
		ConsumerReq consumerReq=fetchByConsumerId(consumerid);
		ComplaintReq response=complaintutil.complaintReq(complaint,consumerid);
		return response;
		
	}

	private ConsumerReq fetchByConsumerId(int consumerid) {
		String url = "http://localhost:8181/consumers/get/" + consumerid;
		ConsumerReq req = restTemplate.getForObject(url, ConsumerReq.class);
		return req;
	}
	@GetMapping("/get/{id}")
	public ComplaintReq getComplaint(@PathVariable("id") int id) {
		Complaint complaint = complaintservice.getComplaintById(id);
		int consumerid = complaint.getConsumerId();
		ConsumerReq consumerReq = fetchByConsumerId(consumerid);
		ComplaintReq response = complaintutil.complaintReq(complaint, consumerid);
		return response;
	}
	@GetMapping("/consumer/{consumerId}")
	public List<ComplaintReq> fetchAllComplaints(@PathVariable("consumerid") int consumerid) {
		List<Complaint> list = complaintservice.allComplaintsByConsumer(consumerid);
		List<ComplaintReq> response = new ArrayList<>();
		ConsumerReq consumerReq = fetchByConsumerId(consumerid);
		for (Complaint complaint : list) {
			ComplaintReq complaintReq = complaintutil.complaintReq(complaint, consumerid);
			response.add(complaintReq);
		}
		return response;
	}

}
