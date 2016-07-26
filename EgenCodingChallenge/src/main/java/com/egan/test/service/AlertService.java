package com.egan.test.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egan.test.repository.AlertRepository;
import com.egan.test.vo.AlertDetails;

@Service
public class AlertService {
	@Autowired
	private AlertRepository alertRepository;
	public void create(AlertDetails alertDetail) {
		alertRepository.create(alertDetail);
	}

	
	public List<AlertDetails> read() {
		// TODO Auto-generated method stub
		return alertRepository.read();
	}

	
	public List<AlertDetails> readByTimeRange(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return alertRepository.readByTimeRange(startDate,endDate);
	}
}
