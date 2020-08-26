package com.dxctraining.util;

import org.springframework.stereotype.Component;

import com.dxctraining.complaint.entities.Complaint;
import com.dxctraining.dto.ComplaintReq;


@Component
		public class ComplaintUtil {

			public static ComplaintReq complaintReq(Complaint complaint, int consumerId) {
				ComplaintReq complaintReq = new ComplaintReq(complaint.getConsumerId(),complaint.getDescription());
				complaintReq.setConsumerId(consumerId);
				return complaintReq;
			}
		}



